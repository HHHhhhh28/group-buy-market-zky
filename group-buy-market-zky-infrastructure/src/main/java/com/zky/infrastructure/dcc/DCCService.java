package com.zky.infrastructure.dcc;

import com.zky.types.annotations.DCCValue;
import org.springframework.stereotype.Service;

/**
 * @author : zky
 * @description :
 * @createDate : 2025/7/14 22:04
 */
@Service
public class DCCService {

    @DCCValue("downgradeSwitch:0")
    private String downgradeSwitch;
    @DCCValue("cutRange:100")
    private String cutRange;

    public boolean isDowngradeSwitch() {
        return "1".equals(downgradeSwitch);
    }

    public boolean isCutRange(String userId) {
        int hashCode = Math.abs(userId.hashCode());
        int lastTwoDigits = hashCode % 100;
        if(lastTwoDigits <= Integer.parseInt(cutRange)) {
            return true;
        }
        return false;
    }
}

