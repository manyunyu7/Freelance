package com.litziy.kawalcovid.util;

public class URL {

    static final String PRIXA_AI = "https://prixa.ai/";
    public static final String INDONESIA_SUMMARY = "https://data.covid19.go.id/public/api/update.json";
    static final String _BASE = "https://indonesia-covid-19.mathdro.id/api/";
    static final String _PROVINCE = "${_BASE}provinsi";

    static final String _DAILY = "${_BASE}harian";
    static final String _HOSPITAL = "https://indonesia-covid-19.mathdro.id/api/harian";
    static final String _LIVE = "https://www.trackcorona.live/map";

    static final String BASE_URL = "https://lapor-satgas.feylaboratory.xyz/api";

    static final String DETAIL_CHART = "https://data.covid19.go.id/public/api/data.json";
    public static final String HOSPITAL_FETCH = BASE_URL+"/hospital/fetch";
    public static final String NEWS_FETCH = BASE_URL+"/news/fetchAll";
}
