package com.devcamp.api.task_56ddot10rainbow_request_input.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

@Service
public class RainbowService {
    private String[] listRainbows = { "red", "orange", "yellow", "green", "blue", "indigo", "purple" };

    public ArrayList<String> filterRainbows(String keyword) {

        ArrayList<String> rainbows = new ArrayList<String>();
        for (String rainbow : this.listRainbows) {
            if (rainbow.contains(keyword)) {
                rainbows.add(rainbow);
            }
        }
        return rainbows;
    }

    public String getRainbows(int index) {
        String rainbow = "0";
        if (index >= 0 && index <= 6) {
            rainbow = this.listRainbows[index];
        }
        return rainbow;

    }
}
