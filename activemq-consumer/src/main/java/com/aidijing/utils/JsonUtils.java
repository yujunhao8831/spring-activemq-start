package com.aidijing.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import java.text.SimpleDateFormat;
import java.util.Map;

/**
 * json工具类
 *
 * @author : 披荆斩棘
 * @date : 2016/10/2
 */
public abstract class JsonUtils {

    public static final Gson GSON = new Gson();

    public static class Jackson {
        private static final ObjectMapper MAPPER = new ObjectMapper()
                .setDateFormat( new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" ) );


        public static ObjectMapper getMAPPER () {
            return MAPPER;
        }

        public static String toJson ( Object data ) {
            try {
                return MAPPER.writeValueAsString( data );
            } catch ( JsonProcessingException e ) {
            }
            return null;
        }


        public static Map jsonToMap ( String jsonData ) {
            try {
                return MAPPER.readValue( jsonData, Map.class );
            } catch ( Exception e ) {
            }
            return null;
        }

        public static < T > T jsonToPojo ( String jsonData, Class< T > beanType ) {
            try {
                MAPPER.enable( MapperFeature.SORT_PROPERTIES_ALPHABETICALLY );
                return MAPPER.readValue( jsonData, beanType );
            } catch ( Exception e ) {
                e.printStackTrace();
            }
            return null;
        }
    }


}
