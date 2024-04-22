package com.geomin.project.GameService;


import com.geomin.project.command.GameContentVO;

public interface GameService {
    GameContentVO findGameContentById(Integer gameNo);
}
