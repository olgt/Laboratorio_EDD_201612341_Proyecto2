/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GoogleMap;
import com.teamdev.jxmaps.swing.MapView;
import com.teamdev.jxmaps.*;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Oscar
 */
public class Mapa extends MapView {
    private Map map;
    
    public Mapa(MapViewOptions opciones){
        super(opciones);
        setOnMapReadyHandler(new MapReadyHandler(){
            @Override
            public void onMapReady(MapStatus ms){
                if(ms == MapStatus.MAP_STATUS_OK){
                    map = getMap();
                    MapOptions mapOptions = new MapOptions();
                    MapTypeControlOptions mt = new MapTypeControlOptions();
                    mt.setPosition(ControlPosition.BOTTOM_LEFT);
                    mapOptions.setMapTypeControlOptions(mt);
                    map.setOptions(mapOptions);
                    
                    map.setCenter(new LatLng(14.642449, -90.513563));
                    map.setZoom(15);
                }
            }
        });
    }
    
    public void centrarEnUsuario(LatLng latLng) {
        map.setCenter(latLng);
    }

    public void esperar() {
        System.out.println("Esperando");
        try {
            for (int i = 0; i < 2; i++) {
                TimeUnit.SECONDS.sleep(1);
                System.out.print(".");
            }
        } catch (Exception e) {
            System.out.print(e);
        }
        System.out.println("genereando");
    }
    
    public Marker agregarMarcador(LatLng coordenada){
        Marker marcador = new Marker(map);
        marcador.setPosition(coordenada);
        map.setCenter(coordenada);
        System.out.println("Marcador Agregado");
        return marcador;
    }
    
    public void agregarLinea(LatLng inicio, LatLng fin, boolean marcador){
        LatLng[] linea = {inicio, fin};
        Polyline pl = new Polyline(map);
        
        pl.setPath(linea);
        
        if(marcador){
            agregarMarcador(inicio);
            agregarMarcador(fin);
        }
    }
    
    public void agregarGrafo(LatLng camino[], boolean marcador){
        Polyline pl = new Polyline(map);
        pl.setPath(camino);
        
        if(marcador){
            for(LatLng c : camino){
                agregarMarcador(c);
            }
        }
    }
}

