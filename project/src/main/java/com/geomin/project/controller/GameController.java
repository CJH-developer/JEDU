package com.geomin.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.geomin.project.GameService.GameServiceImpl;
import com.geomin.project.command.GameContentVO;


@RestController
public class GameController {
	@Autowired
	@Qualifier("gameService")
    private final GameServiceImpl gameService;
    
    public <GameService> GameController(GameServiceImpl gameService) {
        this.gameService = gameService;
    }

    @GetMapping("/api/games/{gameNo}")
    public ResponseEntity<GameContentVO> getGameContent(@PathVariable Integer gameNo) {
        GameContentVO gameContent = gameService.findGameContentById(gameNo);
        if(gameContent == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(gameContent);
    }
}
