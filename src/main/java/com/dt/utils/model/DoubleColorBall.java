package com.dt.utils.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "double_color_ball")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DoubleColorBall {
    @Column(name = "op_id")
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String opId;

    private String number;

    @Column(name = "op_day")
    private String opDay;

    /**
     * @return op_id
     */
    public String getOpId() {
        return opId;
    }

    /**
     * @param opId
     */
    public void setOpId(String opId) {
        this.opId = opId;
    }

    /**
     * @return number
     */
    public String getNumber() {
        return number;
    }

    /**
     * @param number
     */
    public void setNumber(String number) {
        this.number = number;
    }

    /**
     * @return op_day
     */
    public String getOpDay() {
        return opDay;
    }

    /**
     * @param opDay
     */
    public void setOpDay(String opDay) {
        this.opDay = opDay;
    }
}