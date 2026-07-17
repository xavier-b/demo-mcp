package com.example.demo_mcp;

import org.springframework.ai.mcp.annotation.McpTool;
import org.springframework.ai.mcp.annotation.McpToolParam;
import org.springframework.stereotype.Service;

@Service
public class WeatherService {

//    @McpTool(description = "Get current temperature for a location")
//    public String getTemperature(
//            @McpToolParam(description = "City name", required = true) String city) {
//        return String.format("Current temperature in %s: 22°C", city);
//    }

    @McpTool(description = "Get current meteo for a location")
    public MeteoDTO getTemperature(
            @McpToolParam(description = "City name", required = true) String city) {
        MeteoDTO meteoDTO = new MeteoDTO();
        meteoDTO.setTemperature(22.5);
        meteoDTO.setHumidity(80.0);
        return meteoDTO;
    }
}