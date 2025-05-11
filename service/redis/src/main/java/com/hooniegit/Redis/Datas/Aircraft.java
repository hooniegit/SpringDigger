package com.hooniegit.Redis.Datas;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.time.Instant;

/**
 * @Data :: Getter / Setter / equals / hashCode / toString 생성
 * @JsonIgnoreProperties(ignoreUnknown=true) :: JSON response field 중 클래스에 상응하는 변수가 없으면 스킵
 * @Id :: 데이터베이스 항목에 고유 식별자를 가지도록 구성
 * @JsonProperty("vert_rate") :: 멤버 변수를 다른 이름이 붙은 JSON response field 와 연결
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Aircraft {

    @Id
    private Long id;
    private String callsign, squawk, reg, flightno, route, type, category;
    private int altitude, heading, speed;
    @JsonProperty("vert_rate")
    private int vertRate;
    @JsonProperty("selected_altitude")
    private int selectedAltitude;
    private double lat, lon, barometer;
    @JsonProperty("polar_distance")
    private double polarDistance;
    @JsonProperty("polar_bearing")
    private double polarBearing;
    @JsonProperty("is_adsb")
    private boolean isADSB;
    @JsonProperty("is_on_ground")
    private boolean isOnGround;
    @JsonProperty("last_seen_time")
    private Instant lastSeenTime;
    @JsonProperty("pos_update_time")
    private Instant posUpdateTime;
    @JsonProperty("bds40_seen_time")
    private Instant bds40_seenTime;

    public String getLastSeenTime() {
        return this.lastSeenTime.toString();
    }

    public void setLastSeenTime(String lastSeenTime) {
        if (null != lastSeenTime) {
            this.lastSeenTime = Instant.parse(lastSeenTime);
        } else {
            this.lastSeenTime = Instant.ofEpochSecond(0);
        }
    }

    public String getPosUpdateTime() {
        return this.posUpdateTime.toString();
    }

    public void setPosUpdateTime(String posUpdateTime) {
        if (null != posUpdateTime) {
            this.posUpdateTime = Instant.parse(posUpdateTime);
        } else {
            this.posUpdateTime = Instant.ofEpochSecond(0);
        }
    }

    public String getBds40_seenTime() {
        return this.bds40_seenTime.toString();
    }

    public void setBds40_seenTime(String bds40_seenTime) {
        if (null != bds40_seenTime) {
            this.bds40_seenTime = Instant.parse(bds40_seenTime);
        } else {
            this.bds40_seenTime = Instant.ofEpochSecond(0);
        }
    }

}
