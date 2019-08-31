package com.previred.periodos.service;
import com.previred.client.periodos.swagger.codegen.api.PeriodosApi;
import com.previred.periodos.swagger.codegen.model.Periodo;
import com.previred.periodos.tools.ProcessDate;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import org.threeten.bp.DateTimeUtils;

/**
 *
 * @author mgonzalez@previred.com
 */
@Service
public class PeriodosService {

    /**
     * Se consulta el objeto periodo de la API
     * Se procesan las fechas buscando las faltantes
     * Se retorna la lista con las fechas faltantes
     *
     * @return
     */
    public Periodo getPeriodos() {
    	//Se instancia cliente API REST 
    	PeriodosApi periodosApi = new PeriodosApi();
    	com.previred.client.periodos.swagger.codegen.model.Periodo periodoCliente = periodosApi.periodos();
       
    	//Objeto de la API a retornar 
        Periodo periodo = new Periodo();
        periodo.setId(periodoCliente.getId());
        
        periodo.setFechaCreacion(ProcessDate.ld2LD(periodoCliente.getFechaCreacion()));
        periodo.setFechaFin(ProcessDate.ld2LD(periodoCliente.getFechaFin()));
        
        List<LocalDate> lF = new ArrayList<LocalDate>();
        List<LocalDate> lD = new ArrayList<LocalDate>();
        LocalDate ld1,ld2;
        
        for(int i = 0; i < periodoCliente.getFechas().size(); i++){
        	lD.add(ProcessDate.ld2LD(periodoCliente.getFechas().get(i)));
        }
        
        for(int i = 0; i < periodoCliente.getFechas().size()-1; i++){
        	ld1 = ProcessDate.ld2LD(periodoCliente.getFechas().get(i));
        	ld2 = ProcessDate.ld2LD(periodoCliente.getFechas().get(i+1));
        	lF.addAll(ProcessDate.datesRange(ld1, ld2));
        }
        periodo.setFechas(lD);
        periodo.setFechasFaltantes(lF);
        return periodo;
    }
}