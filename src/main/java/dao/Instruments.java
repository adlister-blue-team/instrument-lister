package dao;

import models.Instrument;

import java.util.List;

public interface Instruments {
    //get a list of all the instruments
    List<Instrument> all();
    //insert a new ad and return the new instrument's id
    Long insert(Instrument instrument);


}
