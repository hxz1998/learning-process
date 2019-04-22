import sys

import pygame
from time import sleep

from bullet import Bullet
from alien import Alien


def check_events(ai_settings, screen, stats, play_button, ship, bullets):
    # 监听键盘和鼠标事件
    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            sys.exit()
        elif event.type == pygame.KEYDOWN:
            check_keydown_events(event, ai_settings, screen, ship, bullets)
        elif event.type == pygame.KEYUP:
            check_keyup_events(event, ship)
        elif event.type == pygame.MOUSEBUTTONDOWN:
            mouse_x, mouse_y = pygame.mouse.get_pos()
            check_play_button(stats, play_button, mouse_x, mouse_y)


def check_play_button(stats, play_button, mouse_x, mouse_y):
    """在玩家点击了开始时开始游戏"""
    if play_button.rect.collidepoint(mouse_x, mouse_y):
        stats.game_active = True


def ship_hit(ai_settings, stats, screen, ship, aliens, bullets):
    """响应被外星人撞到的飞船"""
    if stats.ship_left > 0:
        stats.ship_left -= 1

        # 清空外星人列表和子弹列表
        aliens.empty()
        bullets.empty()

        # 创建一群新的外星人
        create_fleet(ai_settings, screen, ship, aliens)
        ship.center_ship()

        # 暂停
        sleep(0.5)
    else:
        stats.game_active = False


def check_keydown_events(event, ai_settings, screen, ship, bullets):
    """响应按键"""
    if event.key == 27:
        sys.exit()
    if event.key == pygame.K_RIGHT:
        # 飞船向右移动
        ship.moving_right = True
    elif event.key == pygame.K_LEFT:
        # 飞船向左移动
        ship.moving_left = True
    elif event.key == pygame.K_SPACE:  # 这可能是个虚拟机或者python的bug，K_SPACE的值为32， 空格为0
        # 增加子弹
        fire_bullet(bullets, ai_settings, screen, ship)


def check_keyup_events(event, ship):
    if event.key == pygame.K_RIGHT:
        # 停止飞船向右移动
        ship.moving_right = False
    elif event.key == pygame.K_LEFT:
        # 停止飞船向左移动
        ship.moving_left = False


def update_screen(ai_settings, screen, stats, ship, aliens, bullets,
                  play_button):
    """更新屏幕函数"""
    # 设置背景颜色
    screen.fill(ai_settings.bg_color)

    for bullet in bullets.sprites():
        bullet.draw_bullet()

    # 绘制飞船
    ship.blitme()

    # 绘制外星人
    aliens.draw(screen)

    # 如果游戏处于非激活状态，就绘制play按钮
    if not stats.game_active:
        play_button.draw_button()

    # 让最近绘制的屏幕可见
    pygame.display.flip()


def check_bullet_alien_collisions(ai_settings, screen, ship, aliens, bullets):
    # 更新子弹位置, 并且删除已消失的子弹
    collisions = pygame.sprite.groupcollide(bullets, aliens, True, True)

    if len(aliens) == 0:
        # 删除现有的子弹并且创建一组新的外星人群
        bullets.empty()
        create_fleet(ai_settings, screen, ship, aliens)


def update_bullet(ai_settings, screen, ship, aliens, bullets):
    """更新子弹函数"""
    bullets.update()

    # 删除已经出界了的子弹实例
    for bullet in bullets.copy():
        if bullet.rect.bottom <= 0:
            bullets.remove(bullet)

    check_bullet_alien_collisions(ai_settings, screen, ship, aliens, bullets)


def fire_bullet(bullets, ai_settings, screen, ship):
    # 子弹发射
    if len(bullets) < ai_settings.bullet_allow:
        new_bullet = Bullet(ai_settings, screen, ship)
        bullets.add(new_bullet)


def get_number_aliens_x(ai_settings, alien_width):
    """创建一个外星人，并计算一行可以容纳多少个外星人， 外星人间距为外星人宽度"""
    available_space_x = ai_settings.screen_width - 2 * alien_width
    number_aliens_x = int(available_space_x / (2 * alien_width))
    return number_aliens_x


def get_number_rows(ai_settings, ship_height, alien_height):
    """计算屏幕可以放下多少外星人"""
    available_space_y = (ai_settings.screen_height -
                         (3 * alien_height) - ship_height)
    number_rows = int(available_space_y / (2 * alien_height))
    return number_rows


def create_alien(ai_settings, screen, aliens, alien_number, row_number):
    """创建一个外星人并将其放在当前行"""
    alien = Alien(ai_settings, screen)
    alien_width = alien.rect.width
    alien.x = alien_width + 2 * alien_width * alien_number
    alien.rect.x = alien.x
    alien.rect.y = alien.rect.height + 2 * alien.rect.height * row_number
    aliens.add(alien)


def create_fleet(ai_settings, screen, ship, aliens):
    """创建外星人群组"""
    # 创建一个外星人，并计算一行可以容纳多少个外星人， 外星人间距为外星人宽度
    alien = Alien(ai_settings, screen)
    number_aliens_x = get_number_aliens_x(ai_settings, alien.rect.width)
    number_rows = get_number_rows(ai_settings, ship.rect.height,
                                  alien.rect.height)

    # 创建外星人群
    for row_number in range(number_rows):
        for alien_number in range(number_aliens_x):
            create_alien(ai_settings, screen, aliens, alien_number, row_number)


def update_aliens(ai_settings, stats, screen, ship, aliens, bullets):
    """更新外星人群中所有外星人的位置"""
    check_fleet_edges(ai_settings, aliens)
    aliens.update()

    # 检测外星人和飞船之间的碰撞
    if pygame.sprite.spritecollideany(ship, aliens):
        ship_hit(ai_settings, stats, screen, ship, aliens, bullets)

    # 检查是否有外星人到了屏幕底端
    check_aliens_bottom(ai_settings, stats, screen, ship, aliens, bullets)


def check_fleet_edges(ai_settings, aliens):
    """有外星人到达边缘时采取相应措施"""
    for alien in aliens.sprites():
        if alien.check_edges():
            change_fleet_direction(ai_settings, aliens)
            break


def change_fleet_direction(ai_settings, aliens):
    """将所有外星人下移，并改变方向"""
    for alien in aliens.sprites():
        alien.rect.y += ai_settings.fleet_drop_speed
    ai_settings.fleet_direction *= -1


def check_aliens_bottom(ai_settings, stats, screen, ship, aliens, bullets):
    """检查是否有外星人到达了屏幕底端"""
    screen_rect = screen.get_rect()
    for alien in aliens.sprites():
        if alien.rect.bottom >= screen_rect.bottom:
            # 像飞船被撞到一样处理
            ship_hit(ai_settings, stats, screen, ship, aliens, bullets)
            break
