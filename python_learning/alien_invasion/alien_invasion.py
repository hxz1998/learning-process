import sys

import pygame
from pygame.sprite import Group

from setting import Settings
from ship import Ship
import game_function as gf
from game_stats import GameStats
from button import Button


def run_game():
    # 初始化整个游戏对象
    pygame.init()
    ai_settings = Settings()
    screen = pygame.display.set_mode(
        (ai_settings.screen_width, ai_settings.screen_height))
    pygame.display.set_caption("Alien Invasion")

    # 创建一个用于统计游戏信息的实例
    stats = GameStats(ai_settings)

    # 创建一个飞船
    ship = Ship(ai_settings, screen)

    # 创建一个用于存储子弹的编组
    bullets = Group()

    # 创建一个外星人群组
    aliens = Group()
    gf.create_fleet(ai_settings, screen, ship, aliens)

    # 创建play按钮
    play_button = Button(ai_settings, screen, "play")

    # 游戏主循环
    while True:
        gf.check_events(ai_settings, screen, stats, play_button, ship, bullets)
        if stats.game_active:
            ship.update()
            gf.update_bullet(ai_settings, screen, ship, aliens, bullets)
            gf.update_aliens(ai_settings, stats, screen, ship, aliens, bullets)
        gf.update_screen(ai_settings, screen, stats, ship, aliens, bullets,
                         play_button)


# 启动游戏
run_game()
