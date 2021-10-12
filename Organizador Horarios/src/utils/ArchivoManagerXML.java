/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import fuentes.Dia;
import fuentes.Horario;
import fuentes.HorarioMateria;
import fuentes.Materia;
import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author Adrian Coloma
 */
public class ArchivoManagerXML extends ArchivoManager{
    private final DocumentBuilder builder = getDocumentBuilder();
    private DOMImplementation implementation = builder.getDOMImplementation();
    private final Transformer transformer = getTransformer();
    private DocumentBuilder getDocumentBuilder(){
        try {
            return DocumentBuilderFactory.newInstance().newDocumentBuilder();
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(ArchivoManagerXML.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    private Transformer getTransformer(){
        try {
            return TransformerFactory.newInstance().newTransformer();
        } catch (TransformerConfigurationException ex) {
            return null;
        }
    }
   
    @Override
    public Horario cargarHorario(String path) {
        try {
            Document documento = builder.parse(new File(path));
            Element materias = (Element) documento.getDocumentElement().getFirstChild();
            boolean materiasRepetidas = Boolean.parseBoolean(materias.getAttribute("materias_repetidas"));
            if(!materiasRepetidas)
                return new Horario(getLista(documento), false);
        } catch (SAXException | IOException ex) {
            Logger.getLogger(ArchivoManagerXML.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }

    @Override
    public ArrayList<Materia> cargarLista(String path) {
        try {
            Document documento = builder.parse(new File(path));
            return getLista(documento);
        } catch (SAXException | IOException ex) {
            Logger.getLogger(ArchivoManagerXML.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    public ArrayList<Materia> getLista(Document documento) {
        ArrayList<Materia> materias = new ArrayList<>();
        
        NodeList listaMaterias = documento.getElementsByTagName("materia");
        for(int i = 0; i < listaMaterias.getLength(); i++){
            Node nodo = listaMaterias.item(i);
            if(nodo.getNodeType() == Node.ELEMENT_NODE){
                Element elemento = (Element) nodo;
                Materia materia = elementToMateria(elemento);
                materias.add(materia);
            }
        }
        
        return materias;
    }
    
    private Materia elementToMateria(Element elemento){
        String nombreMateria = elemento.getAttribute("nombre");
        Color color = new Color(Integer.parseInt(elemento.getAttribute("color")));
        String atributoPrioridad = elemento.getAttribute("prioridad");
        int prioridad = 0;
        if(!atributoPrioridad.isEmpty())
            prioridad = Integer.parseInt(atributoPrioridad);
        
        Materia materia = new Materia(nombreMateria, color, prioridad);
        
        NodeList listaDias = elemento.getElementsByTagName("horario_materia");
        for(int i = 0; i < listaDias.getLength(); i++){
            Node nodo = listaDias.item(i);
            if(nodo.getNodeType() == Node.ELEMENT_NODE){
                Element elementoDia = (Element) nodo;
                Dia dia = Dia.valueOf(elementoDia.getAttribute("dia"));
                int horaInicio = Integer.parseInt(elementoDia.getAttribute("hora_inicio"));
                int horaFinal = Integer.parseInt(elementoDia.getAttribute("hora_final"));
                
                materia.addDia(dia, horaInicio, horaFinal);
            }
        }
        
        return materia;
    }
    

    @Override
    public void guardarHorario(Horario horario, String path) {
        guardar(horario.getMaterias(), path, false);
    }
    
    private void guardar(List<Materia> listaMaterias, String path, boolean materiasRepetidas){
        Document documento = implementation.createDocument(null, "Horario", null);
        documento.setXmlVersion("1.0");
        
        Element materias = documento.createElement("materias");
        materias.setAttribute("materias_repetidas", Boolean.toString(materiasRepetidas));
        documento.getDocumentElement().appendChild(materias);
        
        for(Materia materia : listaMaterias){
            Element materiaElement = materiaToElement(materia, documento);
            materias.appendChild(materiaElement);
        }        
        
        String pathExtension = path + ".";
        if(materiasRepetidas)
            pathExtension += extensionLista;
        else
            pathExtension += extensionHorario;
        
        Source source = new DOMSource(documento);
        Result result = new StreamResult(new File(pathExtension));
        
        try {
            transformer.transform(source, result);
        } catch (TransformerException ex) {
            Logger.getLogger(ArchivoManagerXML.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    private Element materiaToElement(Materia materia, Document documento){
        Element materiaElement = documento.createElement("materia");
        materiaElement.setAttribute("nombre", materia.nombreMateria);
        materiaElement.setAttribute("color", Integer.toString(materia.getColor().getRGB()));
        materiaElement.setAttribute("prioridad", Integer.toString(materia.getPrioridad()));
        
        for(HorarioMateria horario : materia.dias){
            Element dia = documento.createElement("horario_materia");
            dia.setAttribute("dia", horario.dia.toString());
            dia.setAttribute("hora_inicio", Integer.toString(horario.horaInicio));
            dia.setAttribute("hora_final", Integer.toString(horario.horaFinal));
            
            materiaElement.appendChild(dia);
        }
        
        return materiaElement;
    }
    

    @Override
    public void guardarLista(ArrayList<Materia> listaMaterias, String path) {
        guardar(listaMaterias, path, true);
    }

    
}
