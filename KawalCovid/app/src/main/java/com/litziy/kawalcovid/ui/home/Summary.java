package com.litziy.kawalcovid.ui.home;

public class Summary {

    public String newDeath, newHealed, newPositive, totalDeath, totalHealed, totalPositive, totalOnHospital,
            odp, negative;

    Summary(String newDeath, String newHealed, String newPositive,
            String totalDeath, String totalHealed, String totalPositive, String totalOnHospital,
            String odp, String negative) {
        this.newDeath = newDeath;
        this.newHealed = newHealed;
        this.newPositive = newPositive;
        this.totalDeath = totalDeath;
        this.totalHealed = totalHealed;
        this.totalOnHospital = totalOnHospital;
        this.odp = odp;
        this.negative = negative;
        this.totalPositive = totalPositive;
    }


}
