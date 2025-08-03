package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MahaMantraController {

    @GetMapping("/")
    public String getHome() {
        return "🌸 Welcome to Goloka Dham 🌸 — Nitya Leela Dham Radhe Krishna Param Dham, where divine bliss flows eternally.";
    }

    @GetMapping("/mahamantra")
    public String getMahamantra() {
        return "🕉️ Hare Krishna Hare Krishna Krishna Krishna Hare Hare \nHare Rama Hare Rama Rama Rama Hare Hare 🕉️";
    }

    @GetMapping("/radhekrishna")
    public String getRadheKrishna() {
        return "💖 Radhe Radhe! Radha is the heart of Krishna, and Krishna is the soul of Radha.";
    }

    @GetMapping("/goloka")
    public String getGoloka() {
        return "Goloka Vrindavan is the eternal spiritual planet, where every step is a dance and every word is a song.";
    }

    @GetMapping("/blessing")
    public String getBlessing() {
        return "May Lord Krishna bless you with peace, love, and eternal devotion. Chant and be happy!";
    }

    @GetMapping("/chant")
    public String getChantingReminder() {
        return "🌼 Chant the Holy Name daily:\n16 rounds of Hare Krishna Mahamantra to cleanse the mirror of the heart.";
    }

    @GetMapping("/philosophy")
    public String getPhilosophy() {
        return "True happiness is not in possessions but in surrendering to the Supreme Lord with love and devotion.";
    }
}
