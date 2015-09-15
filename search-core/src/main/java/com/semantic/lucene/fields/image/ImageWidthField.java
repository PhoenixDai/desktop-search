/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.semantic.lucene.fields.image;

import com.semantic.lucene.util.IFieldProperty;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.IntField;

/**
 * image width in pixel (datatype - int)
 * @author Christian
 */
public class ImageWidthField implements IFieldProperty<Integer> {

    public static final String NAME = "image_width";

    @Override
    public Class<Integer> getClazz() {
        return Integer.class;
    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public void add(Document doc, Integer value) {
        doc.add(new IntField(getName(), value, Field.Store.YES));
    }
}