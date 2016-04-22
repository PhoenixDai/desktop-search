/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.semantic.lucene.fields.image;

import com.semantic.lucene.util.IFieldProperty;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.DoublePoint;

/**
 * GPS field TAG_GPS_LONGITUDE in decimal degree (datatype - double)
 * @author Christian
 */
public class LonField implements IFieldProperty<Double> {

    public static final String NAME = "image_exif_gps_lon";

    @Override
    public Class<Double> getClazz() {
        return Double.class;
    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public void add(Document doc, Double value) {
        doc.add(new DoublePoint(getName(), value));
    }
}
