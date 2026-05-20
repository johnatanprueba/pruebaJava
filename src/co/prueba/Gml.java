package co.prueba;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Console;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.Normalizer;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.OptionalInt;
import java.util.ResourceBundle;
import java.util.TreeMap;
import java.util.function.LongFunction;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

record Careno(int numero, String nombre) {
};

interface I1 {
	default void saludar() {
	}
	
	int getCantidad();
	
	private void saludarDos() {
		saludar();
		getCantidad();
	}
}

interface I2 {
	default void saludar() {
	}
}

class Chimpance implements Serializable {

	protected transient String name;
	private transient int age;

	public Chimpance() {
		this.name = "Hola";
		this.age = 10;
	}

	public Chimpance(String nombre, int edad) {
		this.name = nombre;
		this.age = edad;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void saludarT() {
	}

}

class BebeChimpace extends Chimpance {
	private String mother = "moom";

	public BebeChimpace(String nombre) {
		super(nombre, 0);
	}

	public String getMother() {
		this.name = "ss";
		return mother;
	}

	public void setMother(String mother) {
		this.saludarT();
		this.mother = mother;
	}

	@Override
	public String toString() {
		return "nombre=" + getName() + ",edad=" + getAge() + ",madre=" + this.mother;
	}
}

record MisListasMunicipis(List<String> listMuniPDF, List<String> listMuniBD) {
}

public class Gml {

	public static void main(String... args) throws Exception {

		try {

			// String contect = Files.readString(Path.of("D:/OCP17_IO/Filea.txt"));
			// Files.writeString(Path.of("D:/OCP17_IO/Fileb.txt"),contect);

			// byte[] bytes = Files.readAllBytes(Path.of("D:/OCP17_IO/Filea.txt"));
			// Files.write(Path.of("D:/OCP17_IO/Fileb.txt"), bytes);

			// List<String> lisStr = Files.readAllLines(Path.of("D:/OCP17_IO/Filea.txt"));
			// Files.write(Path.of("D:/OCP17_IO/Fileb.txt"), lisStr);

		} catch (Exception e) {
			// TODO: handle exception
		}

		// generarUpdate();

		// calcularInsertMuni();

		String sql = "select  "
				+ "w.idTercero  " //0
				+ ",w.FechaIngreso    " //1 -- Falta validar para tener encuenta el meso quincena actual (NIE002)  
				+ ",w.FechaLiquidacionInicio   " //2 -- NIE004  
				+ ",w.FechaLiquidacionFin   " //3 -- NIE005  
				+ ",w.TiempoLaborado   " //4 -- NIE006  
				+ ",w.CodigoTrabajadorA   " //5 -- NIE009  
				+ "  "
				+ ",w.Pais   " //6 -- NIE013  
				+ ",w.DepartamentoEstado   " //7 --NIE014  
				+ ",w.MunicipioCiudad   " //8 -- NIE015  
				+ ",w.Idioma   " //9 -- NIE016  
				+ "   "
				+ ",w.PeriodoNomina  " //10 -- NIE029 tabla 5.5.1  
				+ ",w.TipoMoneda   " //11 -- NIE030   
				+ ",w.RazonSocial   " //12 -- NIE032  
				+ ",w.NIT   " //13 -- NIE033  
				+ ",w.DV   " //14 -- NIE034  
				+ "  "
				+ ",w.PaisEmpl   " //15 -- NIE035  
				+ ",w.DepartamentoEstadoEmpl   " //16 -- NIE036  
				+ ",w.MunicipioCiudadEmpl   " //17 -- NIE037  
				+ "  "
				+ ",w.direccion   " //18 -- NIE038  
				+ ",w.TipoTrabajador   " //19 -- NIE041  
				+ ",w.SubTipoTrabajador   " //20 -- NIE042  
				+ ",w.AltoRiesgoPension   " //21 -- NIE043  
				+ "  "
				+ ",w.TipoDocumento   " //22 -- NIE044  
				+ ",w.NumeroDocumento   " //23 -- NIE045  
				+ ",w.PrimerApellido   " //24 -- NIE046  
				+ ",w.SegundoApellido   " //25 -- NIE047  
				+ ",w.PrimerNombre   " //26 -- NIE048  
				+ ",w.OtrosNombres   " //27 -- NIE049  
				+ ",w.LugarTrabajoPais   " //28 -- NIE050  
				+ ",w.LugarTrabajoDepartamentoEstado   " //28 --NIE051  
				+ ",w.LugarTrabajoMunicipioCiudad   " //29 -- NIE052  
				+ ",w.LugarTrabajoDireccion   " //30 -- NIE053  
				+ ",w.idContrato  "
				+ ",w.SalarioIntegral   " // -- NIE056  
				+ ",w.TipoContrato   " // -- NIE061  
				+ ",w.Sueldo    " // -- NIE062   
				+ ",w.CodigoTrabajadorB   " // -- NIE063  
				+ ",w.Banco   " // --NIE066  
				+ ",w.TipoCuenta   " // -- NIE067  
				+ ",w.NumeroCuenta   " // -- NIE068  
				+ ",w.FechaPago   " // --NIE203   
				+ ",w.diaslaborados   " // -- NIE069  
				+ ",w.SueldoTrabajado   " // -- NIE070  
				+ ",w.AuxilioTransporte   " // --NIE071  
				+ "  "
				+ ",w.CantidadHoraExtrDiurn   " // -- Cantidad de Horas Extra Diurna(NIE076)  
				+ ",case when w.CantidadHoraExtrDiurn is not null then (select porcentaje  from homologa_codigo_dian where id  = 2) else null end as PorcentajeHoraExtrDiurn    " // -- (NIE077) VER  tabla 5.5.5  
				+ ",w.PagoHoraExtrDiurn   " // -- Es el valor pagado por el tiempo que se trabaja adicional a la jornada legal o pactada contractualmente.(NIE078)  "
				+ "  "
				+ ",w.CantidadtHoExtNoct   " // -- Cantidad de Horas Extras Nocturnas(NIE081)  "
				+ ",case when w.CantidadtHoExtNoct is not null then (select porcentaje  from homologa_codigo_dian where id  = 3) else null end as PorcentajetHoExtNoct   " // --(NIE082) VER  tabla 5.5.5  
				+ ",w.PagotHoExtNoct   " // -- Es el valor pagado por el tiempo que se trabaja adicional a la jornada legal o pactada contractualmente. (NIE083)  
				+ "  "
				+ ",w.CantidadHoRecNoc   " // -- Cantidad de Horas Recargo Nocturno(NIE086)  
				+ ",case when w.CantidadHoRecNoc is not null then (select porcentaje  from homologa_codigo_dian where id  = 4) else null end as PorcentajeHoRecNoc   " // --(NIE087) VER  tabla 5.5.5  
				+ ",w.PagoHoRecNoc   " // -- NIE088  
				+ "  "
				+ ",w.CantidadHoDiDoFe   " // -- Cantidad de Horas Extras Diurnas(NIE091)  
				+ ",case when w.CantidadHoDiDoFe is not null then (select porcentaje  from homologa_codigo_dian where id  = 5) else null end as PorcentajeHoDiDoFe   " // --(NIE092)  VER  tabla 5.5.5  
				+ ",w.PagoHoDiDoFe   " // -- NIE093  "
				+ "  "
				+ ",w.CantidadHoReDoFe   " // -- Cantidad de Horas Recargo Diurno Dominical y Festivos(NIE096)  
				+ ",case when w.CantidadHoReDoFe is not null then (select porcentaje  from homologa_codigo_dian where id  = 6) else null end as PorcentajeHoReDoFe   " // --(NIE097) VER  tabla 5.5.5  
				+ ",w.PagoHoReDoFe   " // -- NIE098  "
				+ "  "
				+ ",w.CantidadHoNoDoFe   " // -- Cantidad de Horas Extras Nocturna Dominical y Festivos (NIE101)  "
				+ ",case when w.CantidadHoNoDoFe is not null then (select porcentaje  from homologa_codigo_dian where id  = 7) else null end as PorcentajeHoNoDoFe   " // --(NIE102) VER  tabla 5.5.5  
				+ ",w.PagoHoNoDoFe   " // -- NIE103  "
				+ "  "
				+ ",w.CantidadHoReNoDoFe   " // -- Cantidad de Horas Recargo Nocturno Dominical y Festivos(NIE106)  "
				+ ",case when w.CantidadHoReNoDoFe is not null then (select porcentaje  from homologa_codigo_dian where id  = 8) else null end as PorcentajeHoNoDoFe   " // --(NIE107) VER  tabla 5.5.5  
				+ ",w.PagoHoReNoDoFe   " // -- NIE108  
				+ "  "
				+ ",w.BonificacionS   " // --NIE139  
				+ "  "
				+ ",w.BonificacionNS   " // -- NIE140  
				+ "  "
				+ ",w.AuxilioNS   " // -- NIE142  
				+ "  "
				+ ",w.ConceptoNS   " // -- NIE148  
				+ "  "
				+ ",w.Comision   " // -- NIE155  
				+ "  "
				+ ",w.ApoyoSost   " // --NIE157  
				+ "  "
				+ ",w.Indemnizacion   " // -- NIE160  
				+ "  "
				+ ",w.PorcentajeSalud   " // -- NIE161  
				+ "  "
				+ ",w.DeduccionSalud  " // -- NIE163  
				+ "  "
				+ ",w.PorcentajePension  " // -- NIE164  
				+ "  "
				+ ",w.DeduccionPension   " // -- NIE166  
				+ "  "
				+ ",w.DescripcionLibr  " // -- NIE175  
				+ "  "
				+ ",w.DeduccionLibr   " // -- NIE176  
				+ "  "
				+ ",w.PagoTercero   " // -- NIE195  
				+ "  "
				+ ",w.Anticipo   " // -- NIE196  
				+ "  "
				+ ",w.PensionVoluntaria   " // -- NIE198  
				+ "  "
				+ ",w.AFC   " // --NIE179  
				+ "  "
				+ ",w.Deuda   " // -- NIE185  
				+ "  "
				+ ",w.DevengadosTotal   " // -- NIE187  
				+ "  "
				+ ",w.DeduccionesTotal   " // -- NIE188  
				+ "  "
				+ ",w. ComprobanteTotal   " // -- NIE189  
				+ "  "
				+ ",w.Correo  "
				+ "  "
				+ ",w.Centro_Trabajo   "
				+ "  "
				+ ",w.Cargo_Empleado  "
				+ "from  "
				+ "(  "
				+ "select   "
				+ "t.idTercero  "
				+ ",t.FechaIngreso    " 
				+ ",min(t.FechaLiquidacionInicio) as FechaLiquidacionInicio   " 
				+ ",max(t.FechaLiquidacionFin) as FechaLiquidacionFin   " 
				+ ",sum(TiempoLaborado) as TiempoLaborado   " 
				+ ",t.CodigoTrabajadorA   " 
				+ "  "
				+ ",t.Pais   "
				+ ",t.DepartamentoEstado   " 
				+ ",t.MunicipioCiudad   " 
				+ ",t.Idioma   " 
				+ "  "
				+ ",5 as PeriodoNomina  "
				+ ",t.TipoMoneda   " 
				+ ",t.RazonSocial   " 
				+ ",t.NIT   " 
				+ ",t.DV   " 
				+ "  "
				+ ",t.PaisEmpl   " 
				+ ",t.DepartamentoEstadoEmpl   " 
				+ ",t.MunicipioCiudadEmpl   " 
				+ "  "
				+ ",t.direccion   " 
				+ ",t.TipoTrabajador   " 
				+ ",t.SubTipoTrabajador   " 
				+ "  "
				+ ",t.AltoRiesgoPension   " 
				+ "  "
				+ ",t.TipoDocumento   " 
				+ "  "
				+ ",t.NumeroDocumento   " 
				+ ",t.PrimerApellido   " 
				+ ",t.SegundoApellido   " 
				+ ",t.PrimerNombre   " 
				+ ",t.OtrosNombres   " 
				+ ",t.LugarTrabajoPais   " 
				+ ",t.LugarTrabajoDepartamentoEstado   " 
				+ ",t.LugarTrabajoMunicipioCiudad   " 
				+ ",t.LugarTrabajoDireccion   " 
				+ ",t.idContrato  "
				+ ",t.SalarioIntegral   " 
				+ ",t.TipoContrato   " 
				+ ",sum(t.Sueldo) as Sueldo    " 
				+ ",t.CodigoTrabajadorB   " 
				+ ",t.Banco   " 
				+ ",t.TipoCuenta   " 
				+ ",t.NumeroCuenta   " 
				+ ",max(t.FechaPago) as FechaPago    " 
				+ ",sum(t.diaslaborados) as diaslaborados   " 
				+ ",sum(t.SueldoTrabajado) as SueldoTrabajado   " 
				+ ",sum(t.AuxilioTransporte) as AuxilioTransporte   " 
				+ "  "
				+ ",sum(t.CantidadHoraExtrDiurn) as CantidadHoraExtrDiurn   " 
				+ ",sum(t.PagoHoraExtrDiurn) as PagoHoraExtrDiurn   " 
				+ "  "
				+ ",sum(t.CantidadtHoExtNoct) as CantidadtHoExtNoct   " 
				+ ",sum(t.PagotHoExtNoct) as  PagotHoExtNoct   "
				+ "  "
				+ ",sum(t.CantidadHoRecNoc) as CantidadHoRecNoc   " 
				+ ",sum(t.PagoHoRecNoc) as PagoHoRecNoc   " 
				+ "  "
				+ ",sum(t.CantidadHoDiDoFe) as CantidadHoDiDoFe   " 
				+ ",sum(t.PagoHoDiDoFe) as PagoHoDiDoFe   " 
				+ "  "
				+ ",sum(t.CantidadHoReDoFe) as CantidadHoReDoFe   " 
				+ ",sum(t.PagoHoReDoFe) as PagoHoReDoFe   " 
				+ "  "
				+ ",sum(t.CantidadHoNoDoFe) as CantidadHoNoDoFe   " 
				+ ",sum(t.PagoHoNoDoFe) as PagoHoNoDoFe   "
				+ "  "
				+ ",sum(t.CantidadHoReNoDoFe) as CantidadHoReNoDoFe   "
				+ ",sum(t.PagoHoReNoDoFe) as PagoHoReNoDoFe   " 
				+ "  "
				+ ",sum(t.BonificacionS) as  BonificacionS   " 
				+ "  "
				+ ",sum(t.BonificacionNS) as BonificacionNS   " 
				+ "  "
				+ ",sum(t.AuxilioNS) as AuxilioNS   " 
				+ "  "
				+ ",sum(t.ConceptoNS) as ConceptoNS   " 
				+ "  "
				+ ",sum(t.Comision) as Comision   "
				+ "  "
				+ ",sum(t.ApoyoSost) as ApoyoSost   " 
				+ "  "
				+ ",sum(t.Indemnizacion) as Indemnizacion   " 
				+ "  "
				+ ",sum(t.PorcentajeSalud) as PorcentajeSalud   " 
				+ "  "
				+ ",sum(t.DeduccionSalud) as DeduccionSalud  " 
				+ "  "
				+ ",sum(t.PorcentajePension) as PorcentajePension  " 
				+ "  "
				+ ",sum(t.DeduccionPension) as DeduccionPension   " 
				+ "  "
				+ ",max(t.DescripcionLibr) as DescripcionLibr  " 
				+ "  "
				+ ",sum(t.DeduccionLibr) as DeduccionLibr   "
				+ "  "
				+ ",sum(t.PagoTercero) as PagoTercero   " 
				+ "  "
				+ ",sum(t.Anticipo) as Anticipo   " 
				+ "  "
				+ ",sum(t.PensionVoluntaria) as PensionVoluntaria   " 
				+ "  "
				+ ",sum(t.AFC) as AFC  " 
				+ "  "
				+ ",sum(t.Deuda) as Deuda " 
				+ "  "
				+ ",sum(t.DevengadosTotal) as DevengadosTotal   " 
				+ "  "
				+ ",sum(t.DeduccionesTotal) as DeduccionesTotal   " 
				+ "  "
				+ ",sum(t.ComprobanteTotal)  as ComprobanteTotal   " 
				+ "  "
				+ ",t.Correo  "
				+ "  "
				+ ",t.Centro_Trabajo  "
				+ "  "
				+ ",t.Cargo_Empleado  "
				+ "  "
				+ "from  "
				+ "(  "
				+ "select  "
				+ "t.id as idTercero  " 
				+ ",de.id  as idDetalle  " 
				+ ",contratoTemp.FechInicio as FechaIngreso     " 
				+ ",de.fecha as FechaLiquidacionInicio   "
				+ ",def.fecha as FechaLiquidacionFin   "
				+ ",DATE_PART('day', CURRENT_DATE - contratoTemp.FechInicio) as TiempoLaborado   " 
				+ ",t.codigo as CodigoTrabajadorA   " 
				+ "  "
				+ ",ups.iso_alfa2digitos  as Pais   " 
				+ ",uds.codigo_dian as DepartamentoEstado   " 
				+ ",ucs.codigo_dian as MunicipioCiudad   "
				+ ",'es' as Idioma   " 
				+ "  "
				+ ",'COP' as TipoMoneda " 
				+ "  "
				+ ",e.nombre as RazonSocial " 
				+ ",e.identificacion as NIT  " 
				+ ",e.digito_verificacion as DV  " 
				+ "  "
				+ ",up.iso_alfa2digitos as PaisEmpl " 
				+ ",ud.codigo_dian  as DepartamentoEstadoEmpl  " 
				+ ",uc.codigo_dian as MunicipioCiudadEmpl   " 
				+ "  "
				+ ",tdm.direccion   " 
				+ "  "
				+ ",tptc.codigo_tipo_trabajador_dian as TipoTrabajador   " 
				+ "  "
				+ ",tpstc.codigo_sub_tipo_trabajador_dian as SubTipoTrabajador  " 
				+ "  "
				+ ",case when tptep.id is not null then 'true' else 'false' end as AltoRiesgoPension   " 
				+ "  "
				+ ",tti.codigo_tipo_identificacion_dian as TipoDocumento   " 
				+ "  "
				+ ",t.identificacion as NumeroDocumento   "
				+ ",t.primer_apellido as PrimerApellido   " 
				+ ",t.segundo_apellido as SegundoApellido   "
				+ ",t.primer_nombre as PrimerNombre   " 
				+ ",t.segundo_nombre as OtrosNombres   "
				+ ",upt.iso_alfa2digitos as LugarTrabajoPais   " 
				+ ",udt.codigo_dian as LugarTrabajoDepartamentoEstado   " 
				+ ",uct.codigo_dian as LugarTrabajoMunicipioCiudad   " 
				+ ",td.direccion as LugarTrabajoDireccion   "
				+ ",contratoTemp.id as idContrato  "
				+ ",contratoTemp.sen_salario_integral as SalarioIntegral   " 
				+ ",contratoTemp.TipoContrato   " 
				+ ",tblSueldo.totalSueldo as Sueldo  " 
				+ ",t.codigo as CodigoTrabajadorB   " 
				+ ",banco.nombre_completo as Banco   " 
				+ ",tptcu.nombre as TipoCuenta   " 
				+ ",tpdb.numero_cuenta as NumeroCuenta   " 
				+ ",defPagNom.fecha as FechaPago   " 
				+ ",tblSueldo.diaslaborados   " 
				+ ",tblSueldo.totalSueldo as SueldoTrabajado   " 
				+ ",tblAuxTrans.auxTrans as AuxilioTransporte   " 
				+ "  "
				+ ",tblHoraExtrDiurn.cantHoExtDiu as CantidadHoraExtrDiurn   " 
				+ ",tblHoraExtrDiurn.valorPagHoExtDiu as PagoHoraExtrDiurn   " 
				+ "  "
				+ ",tblHoraExtrNoct.cantHoExtNoct as CantidadtHoExtNoct   " 
				+ ",tblHoraExtrNoct.valorPagHoExtNoc as PagotHoExtNoct   " 
				+ "  "
				+ ",tblHoraRecNoc.cantHoRecNoc as CantidadHoRecNoc   " 
				+ ",tblHoraRecNoc.valorPagHoRecNoc as PagoHoRecNoc   " 
				+ "  "
				+ ",tblHoraDiDoFe.cantHoDiDoFe as CantidadHoDiDoFe   " 
				+ ",tblHoraDiDoFe.valorPagHoDiDoFe as PagoHoDiDoFe   " 
				+ "  "
				+ ",tblHoraReDoFe.cantHoReDoFe as CantidadHoReDoFe   " 
				+ ",tblHoraReDoFe.valorPagHoReDoFe as PagoHoReDoFe   " 
				+ "  "
				+ ",tblHoraNoDoFe.cantHoNoDoFe as CantidadHoNoDoFe   "
				+ ",tblHoraNoDoFe.valorPagHoNoDoFe as PagoHoNoDoFe   "
				+ "  "
				+ ",tblHoraReNoDoFe.cantHoReNoDoFe as CantidadHoReNoDoFe   " 
				+ ",tblHoraReNoDoFe.valorPagHoReNoDoFe as PagoHoReNoDoFe   " 
				+ "  "
				+ ",tblBonificacionS.bonificaS as BonificacionS   " 
				+ "  "
				+ ",tblBonificacionNS.bonificaNS as BonificacionNS   "
				+ "  "
				+ ",tblAuxilioNS.auxilioNS as AuxilioNS   "
				+ "  "
				+ ",tblConceptoNS.conceptoNS as ConceptoNS   " 
				+ "  "
				+ ",tblComision.comision as Comision   " 
				+ "  "
				+ ",tblApoyoSost.apoyoSost as ApoyoSost   " 
				+ "  "
				+ ",tblIndemnizacion.indemnizacion as Indemnizacion   " 
				+ "  "
				+ ",tblSalud.porcSalud as PorcentajeSalud   "
				+ "  "
				+ ",tblSalud.deducSalud as DeduccionSalud  " 
				+ "  "
				+ ",tblPension.porcPension as PorcentajePension  " 
				+ "  "
				+ ",tblPension.deducPension as DeduccionPension   " 
				+ "  "
				+ ",tblLibranza.desLibranza as DescripcionLibr  " 
				+ "  "
				+ ",tblLibranza.deduLibranza  as DeduccionLibr   " 
				+ "  "
				+ ",tblPagoTercero.pagoTercero as PagoTercero   " 
				+ "  "
				+ ",tblAnticipo.anticipo as Anticipo   " 
				+ "  "
				+ ",tblFondoPension.pensionvoluntaria as PensionVoluntaria   "
				+ "  "
				+ ",tblAhorrCons.afc as AFC   " 
				+ "  "
				+ ",tblPrestamos.deuda as Deuda   " 
				+ "  "
				+ ",dmn.total_devengados as DevengadosTotal   " 
				+ "  "
				+ ",dmn.total_deducciones as DeduccionesTotal   " 
				+ "  "
				+ ",dmn.total_devengados - dmn.total_deducciones as ComprobanteTotal   " 
				+ "  "
				+ "  "
				+ ",tde.email as Correo  "
				+ "  "
				+ ",e.nombre as Centro_Trabajo  "
				+ "  "
				+ ",(select   "
				+ "			tpc.nombre  "
				+ "			from tercero_personal_contrato_cargo tpcc   "
				+ "			inner join tercero_personal_cargo tpc on tpcc.cargo_id =tpc.id and tpc.borrador = false   "
				+ "			where tpcc.contrato_id  = contratoTemp.id  "
				+ "			order by tpcc.fecha_inicio desc   "
				+ "			limit 1) as Cargo_Empleado  "
				+ "  "
				+ "from documento_encabezado de   "
				+ "inner join documento_tipo dt on de.documento_tipo_id  = dt.id  and dt.codigo_documento = 'NO'  "
				+ "left join prefijo p on de.prefijo_id  = p.id  and p.borrador = false   "
				+ "inner join documento_movimiento_nomina dmn on de.id = dmn.documento_encabezado_id and dmn.borrador = false   "
				+ "inner join tercero t on dmn.tercero_id  = t.id and t.borrador = false  "
				+ "left join tercero_direccion td on t.id = td.tercero_id and td.sen_principal = true and td.borrador = false  "
				+ "  "
				+ "left join tercero_direccion_email tde on td.id  = tde.tercero_direccion_id and tde.sen_principal = true and tde.borrador = false  "
				+ "  "
				+ "inner join tercero_tipo_identificacion tti on t.tercero_tipo_identificacion_id = tti .id   "
				+ "  "
				+ "inner join usuario usu on de.creado_por  = usu.id and usu.borrador = false   "
				+ "inner join tercero tu on usu.tercero_id = tu.id and tu.borrador = false   "
				+ "inner join ubicacion_ciudad ucs on tu.ubicacion_ciudad_id  = ucs.id and ucs.borrador = false   "
				+ "inner join ubicacion_departamento uds on ucs.ubicacion_departamento_id  = uds.id and uds.borrador = false    "
				+ "inner join ubicacion_pais ups  on uds.ubicacion_pais_id  = ups.id and ups.borrador = false    "
				+ "  "
				+ "  "
				+ "left join (  "
				+ "			 select  "
				+ "			 tpc.id   "
				+ "			,tpc.tercero_id   "
				+ "			,tpc.sen_salario_integral   "
				+ "			,tpct.empresa_id   "
				+ "			,tptc.id as TipoContrato  "
				+ "			,tpc.fecha_inicio as FechInicio  "
				+ "			from tercero_personal_contrato tpc   "
				+ "			inner join tercero_personal_contrato_centro_trabajo tpcct on tpc.id = tpcct.contrato_id and tpcct.borrador = false   "
				+ "			inner join tercero_personal_centro_trabajo tpct on tpcct.centro_trabajo_id = tpct.id  and tpct.borrador = false   "
				+ "			inner join tercero_personal_tipo_contrato tptc on tpc.tipo_contrato_id  = tptc.id   "
				+ "			where tpc.borrador = false 						  "
				+ "		   ) contratoTemp on t.id  = contratoTemp.tercero_id  and de.empresa_id = contratoTemp.empresa_id and dmn.contrato_id = contratoTemp.id  "
				+ "		     "
				+ "inner join documento_encabezado_fecha def on de.id  = def.documento_encabezado_id    "
				+ "inner join documento_fecha df on def.documento_fecha_id  = df.id and df.codigo  = 'FECHA_FIN_NOMINA'  "
				+ "inner join documento_encabezado_fecha defPagNom on de.id  = defPagNom.documento_encabezado_id  "
				+ "inner join documento_fecha dfPagoNom on defPagNom.documento_fecha_id  = dfPagoNom.id  and dfPagoNom.codigo = 'FECHA_PAGO_NOMINA'  "
				+ "inner join empresa e on de.empresa_id  = e.id and e.borrador = false   "
				+ "left join ubicacion_ciudad uc on e.ubicacion_ciudad_id  = uc.id  and uc.borrador = false  "
				+ "left join ubicacion_departamento ud on uc.ubicacion_departamento_id  = ud.id  and ud.borrador = false   "
				+ "left join ubicacion_pais up on ud.ubicacion_pais_id  = up.id  and up.borrador = false   "
				+ "left join ubicacion_ciudad uct on t.ubicacion_ciudad_id = uct.id and uct.borrador = false   "
				+ "left join ubicacion_departamento udt on uct.ubicacion_departamento_id  = udt.id   "
				+ "left join ubicacion_pais upt on udt.ubicacion_pais_id = upt.id   "
				+ "left join tercero_personal_aporte tpa on t.id  = tpa.tercero_id  and tpa.borrador = false   "
				+ "left join tercero_personal_tipo_cotizante tptc on tpa.tipo_cotizante_id = tptc.id   "
				+ "left join tercero_personal_sub_tipo_cotizante tpstc on  tpa.sub_tipo_cotizante_id = tpstc.id   "
				+ "left join tercero_personal_tarifa_especial_pension tptep on tpa.tarifa_especial_pension_id =tptep.id   "
				+ "  "
				+ "left join tercero_direccion tdm on t.id = tdm.tercero_id and tdm.sen_principal = true and tdm.borrador = false    "
				+ "  "
				+ "left join (  "
				+ "			select   "
				+ "			 de.id as idEncabezado   "
				+ "			,dmn.tercero_id   "
				+ "			,dmnd.valor_total_renglon as totalSueldo  "
				+ "			,case when um.codigo = 'd' then trunc(dmnd.cantidad)  "
				+ "          		  when um.codigo = 's' then trunc(dmnd.cantidad /86400)  "
				+ "         		  when um.codigo  ='h' then trunc(dmnd.cantidad /24)  "
				+ "         		  when um.codigo = 'mes' then trunc(dmnd.cantidad*30)   "
				+ "          		  when um.codigo = 'a' then trunc(dmnd.cantidad  *365)   "
				+ "         		 end diaslaborados   " // -- calculo literal 8.3 PDF Anexo tecnico  
				+ "			from documento_encabezado de   "
				+ "			inner join documento_movimiento_nomina dmn on de.id = dmn.documento_encabezado_id  and dmn.borrador = false   "
				+ "			inner join documento_movimiento_nomina_detalle dmnd on dmn.id = dmnd.documento_movimiento_nomina_id and dmnd.borrador = false   "
				+ "			inner join nomina_concepto nc on dmnd.nomina_concepto_id  = nc.id and nc.borrador = false 			  "
				+ "			inner join unidad_medida um on nc.unidad_medida_id = um.id and um.borrador = false  "
				+ "			inner join unidad_medida_tipo umt on um.unidad_medida_tipo_id  = umt.id 			  "
				+ "			where nc.codigo  = 'Sueld'  "
				+ "			and de.borrador = false   "
				+ "			)  tblSueldo on t.id  = tblSueldo.tercero_id and de.id  = tblSueldo.idEncabezado  "
				+ "left join tercero_personal_datos_basicos tpdb on t.id  = tpdb.tercero_id  and tpdb.borrador = false  "
				+ "left join tercero banco on tpdb.banco_id = banco .id  and banco.borrador = false   "
				+ "left join tercero_personal_tipo_cuenta tptcu on tpdb.tipo_cuenta_id  = tptcu.id   "
				+ "left join (  "
				+ "			select  "
				+ "			 de.id as idEncabezado   "
				+ "			,dmn.tercero_id   "
				+ "			,dmnd.valor_total_renglon as auxTrans  "
				+ "			from documento_movimiento_nomina dmn   "
				+ "			inner join documento_encabezado de on dmn.documento_encabezado_id  = de.id  and de.borrador = false  "
				+ "			inner join tercero t on dmn.tercero_id  = t.id and t.borrador =false  "
				+ "			inner join documento_movimiento_nomina_detalle dmnd on dmn.id = dmnd.documento_movimiento_nomina_id  and dmnd.borrador = false			  "
				+ "			inner join nomina_concepto nc on dmnd.nomina_concepto_id = nc.id  and nc.borrador = false   "
				+ "			where nc.homologa_codigo_dian_id = 1   " // -- in ('Auxtr') Auxilio de transporte		  
				+ "			and dmn.borrador = false	   "
				+ "		  )tblAuxTrans on t.id  = tblAuxTrans.tercero_id and de.id = tblAuxTrans.idEncabezado  "
				+ "left join(  "
				+ "			select   "
				+ "			de.id as idEncabezado  "
				+ "			,t.id as idTercero			   "
				+ "			,sum(dmnd.cantidad) as cantHoExtDiu     "
				+ "			,sum(dmnd.valor_total_renglon) as valorPagHoExtDiu  "
				+ "			from documento_movimiento_nomina dmn   "
				+ "			inner join documento_encabezado de on dmn.documento_encabezado_id  = de.id and de.borrador = false   "
				+ "			inner join tercero t on dmn.tercero_id  = t.id and t.borrador = false  "
				+ "			inner join documento_movimiento_nomina_detalle dmnd on dmn.id = dmnd.documento_movimiento_nomina_id and dmnd.borrador = false  "
				+ "			inner join nomina_concepto nc on dmnd.nomina_concepto_id = nc.id and nc.borrador = false  "
				+ "			inner join homologa_codigo_dian hcd on nc.homologa_codigo_dian_id  = hcd.id   "
				+ "			where hcd.id  = 2   " // -- 'Hexdi'  Codigo nomina cncepto Hora Extra Diurna  
				+ "			and dmn.borrador = false  "
				+ "			group by de.id,t.id  "
				+ "		 )tblHoraExtrDiurn on t.id  = tblHoraExtrDiurn.idTercero and de.id = tblHoraExtrDiurn.idEncabezado  "
				+ "left join(  "
				+ "			select   "
				+ "			de.id as idEncabezado  "
				+ "			,t.id as idTercero			  "
				+ "			,sum(dmnd.cantidad) as cantHoExtNoct  "
				+ "			,sum(dmnd.valor_total_renglon) as valorPagHoExtNoc  "
				+ "			from documento_movimiento_nomina dmn   "
				+ "			inner join documento_encabezado de on dmn.documento_encabezado_id  = de.id and de.borrador = false  "
				+ "			inner join tercero t on dmn.tercero_id  = t.id and t.borrador = false  "
				+ "			inner join documento_movimiento_nomina_detalle dmnd on dmn.id = dmnd.documento_movimiento_nomina_id and dmnd.borrador = false  "
				+ "			inner join nomina_concepto nc on dmnd.nomina_concepto_id = nc.id  and nc.borrador = false   "
				+ "			inner join homologa_codigo_dian hcd on nc.homologa_codigo_dian_id  = hcd.id   "
				+ "			where hcd.id = 3   " // -- 'Hexno' Codigo nomina concepto Hora Extra Nocturna			  
				+ "			and dmn.borrador = false  "
				+ "			group by de.id , t.id  "
				+ "         )	tblHoraExtrNoct on t.id	=  tblHoraExtrNoct.idTercero and de.id = tblHoraExtrNoct.idEncabezado  "
				+ "left join(  "
				+ "			select   "
				+ "			de.id as idEncabezado  "
				+ "			,t.id as idTercero  "
				+ "			,sum(dmnd.cantidad) as cantHoRecNoc  "
				+ "			,sum(dmnd.valor_total_renglon) as valorPagHoRecNoc  "
				+ "			from documento_movimiento_nomina dmn   "
				+ "			inner join documento_encabezado de on dmn.documento_encabezado_id  = de.id and de.borrador = false   "
				+ "			inner join tercero t on dmn.tercero_id  = t.id and t.borrador = false   "
				+ "			inner join documento_movimiento_nomina_detalle dmnd on dmn.id = dmnd.documento_movimiento_nomina_id and dmnd.borrador = false   "
				+ "			inner join nomina_concepto nc on dmnd.nomina_concepto_id = nc.id and nc.borrador = false   "
				+ "			inner join homologa_codigo_dian hcd on nc.homologa_codigo_dian_id  = hcd.id   "
				+ "			where hcd.id  = 4   " // -- 'Recno' Recargo Nocturno			  
				+ "			and dmn.borrador = false   "
				+ "			group by de.id ,t.id   "
				+ "          )tblHoraRecNoc on t.id = tblHoraRecNoc.idTercero and de.id = tblHoraRecNoc.idEncabezado  "
				+ "left join (  "
				+ "			select   "
				+ "			de.id as idEncabezado  "
				+ "			,t.id as idTercero  "
				+ "			,sum(dmnd.cantidad) as cantHoDiDoFe  "
				+ "			,sum(dmnd.valor_total_renglon) as valorPagHoDiDoFe  "
				+ "			from documento_movimiento_nomina dmn   "
				+ "			inner join documento_encabezado de on dmn.documento_encabezado_id  = de.id  and de.borrador = false   "
				+ "			inner join tercero t on dmn.tercero_id  = t.id and t.borrador = false   "
				+ "			inner join documento_movimiento_nomina_detalle dmnd on dmn.id = dmnd.documento_movimiento_nomina_id and dmnd.borrador = false   "
				+ "			inner join nomina_concepto nc on dmnd.nomina_concepto_id = nc.id  and nc.borrador = false   "
				+ "			inner join homologa_codigo_dian hcd on nc.homologa_codigo_dian_id  = hcd.id   "
				+ "			where hcd.id  = 5   " // -- 'Hexdf'  Hora Extra Diurna Dominical o Festiva  
				+ "			and dmn.borrador = false  "
				+ "			group by de.id,t.id  "
				+ "		   )tblHoraDiDoFe on t.id = tblHoraDiDoFe.idTercero and de.id = tblHoraDiDoFe.idEncabezado  "
				+ "left join (  "
				+ "			select   "
				+ "			de.id as idEncabezado  "
				+ "			,t.id as idTercero  "
				+ "			,sum(dmnd.cantidad) as cantHoReDoFe  "
				+ "			,sum(dmnd.valor_total_renglon) as  valorPagHoReDoFe  "
				+ "			from documento_movimiento_nomina dmn   "
				+ "			inner join documento_encabezado de on dmn.documento_encabezado_id  = de.id and de.borrador = false   "
				+ "			inner join tercero t on dmn.tercero_id  = t.id and t.borrador = false   "
				+ "			inner join documento_movimiento_nomina_detalle dmnd on dmn.id = dmnd.documento_movimiento_nomina_id and dmnd.borrador  = false   "
				+ "			inner join nomina_concepto nc on dmnd.nomina_concepto_id = nc.id and nc.borrador = false   "
				+ "			inner join homologa_codigo_dian hcd on nc.homologa_codigo_dian_id  = hcd.id   "
				+ "			where hcd.id  = 6   " // --  'Recfe' Hora Recargo Dominical o Festivo			  
				+ "			and dmn.borrador = false  "
				+ "			group by de.id , t.id  "
				+ "		    )tblHoraReDoFe on t.id = tblHoraReDoFe.idTercero and de.id = tblHoraReDoFe.idEncabezado  "
				+ "left join (  "
				+ "			select  "
				+ "			de.id as idEncabezado  "
				+ "			,t.id as idTercero  "
				+ "			,sum(dmnd.cantidad) as cantHoNoDoFe    "
				+ "			,sum(dmnd.valor_total_renglon) as valorPagHoNoDoFe  "
				+ "			from documento_movimiento_nomina dmn   "
				+ "			inner join documento_encabezado de on dmn.documento_encabezado_id  = de.id  and de.borrador = false   "
				+ "			inner join tercero t on dmn.tercero_id  = t.id and t.borrador = false   "
				+ "			inner join documento_movimiento_nomina_detalle dmnd on dmn.id = dmnd.documento_movimiento_nomina_id and dmnd.borrador = false   "
				+ "			inner join nomina_concepto nc on dmnd.nomina_concepto_id = nc.id and nc.borrador = false   "
				+ "			inner join homologa_codigo_dian hcd on nc.homologa_codigo_dian_id  = hcd.id   "
				+ "			where hcd.id  = 7   " // -- 'Hexnf' Hora Extra Nocturna Dominical o Festiva			  
				+ "			and dmn.borrador = false  "
				+ "			group by de.id , t.id   "
				+ "		  )tblHoraNoDoFe on t.id = tblHoraNoDoFe.idTercero and de.id = tblHoraNoDoFe.idEncabezado  "
				+ "left join(  "
				+ "		   select   "
				+ "		   de.id as idEncabezado  "
				+ "		   ,t.id as idTercero  "
				+ "		   ,sum(dmnd.cantidad) as cantHoReNoDoFe	  "
				+ "		   ,sum(dmnd.valor_total_renglon) as valorPagHoReNoDoFe  "
				+ "		   from documento_movimiento_nomina dmn   "
				+ "	       inner join documento_encabezado de on dmn.documento_encabezado_id  = de.id and de.borrador = false   "
				+ "		   inner join tercero t on dmn.tercero_id  = t.id and t.borrador = false   "
				+ "		   inner join documento_movimiento_nomina_detalle dmnd on dmn.id = dmnd.documento_movimiento_nomina_id and dmnd.borrador = false   "
				+ "		   inner join nomina_concepto nc on dmnd.nomina_concepto_id = nc.id and nc.borrador = false   "
				+ "		   inner join homologa_codigo_dian hcd on nc.homologa_codigo_dian_id  = hcd.id   "
				+ "		   where hcd.id  = 8   " // -- 'Renod'  --Recargo Nocturno Dominical		     
				+ "		   and dmn.borrador = false  "
				+ "		   group by de.id ,t.id   "
				+ "	     )tblHoraReNoDoFe on t.id  = tblHoraReNoDoFe.idTercero and de.id = tblHoraReNoDoFe.idEncabezado  "
				+ "left join(  "
				+ "			select   "
				+ "			de.id as idEncabezado  "
				+ "			,t.id as idTercero  "
				+ "			,sum(dmnd.valor_total_renglon) as bonificaS     "
				+ "			from documento_movimiento_nomina dmn   "
				+ "			inner join documento_encabezado de on dmn.documento_encabezado_id  = de.id  and de.borrador = false  "
				+ "			inner join tercero t on dmn.tercero_id  = t.id and t.borrador =false  "
				+ "			inner join documento_movimiento_nomina_detalle dmnd on dmn.id = dmnd.documento_movimiento_nomina_id  and dmnd.borrador = false  "
				+ "			inner join nomina_concepto nc on dmnd.nomina_concepto_id = nc.id  and nc.borrador = false   "
				+ "			inner join homologa_codigo_dian hcd on nc.homologa_codigo_dian_id  = hcd.id  "
				+ "			where hcd.id = 9   " // -- in ('Bonif')   -- Bonificacion Salarial  
				+ "			and dmn.borrador = false  "
				+ "			group by de.id ,t.id   "
				+ "         )tblBonificacionS on t.id = tblBonificacionS.idTercero and de.id = tblBonificacionS.idEncabezado  "
				+ "left join(  "
				+ "			select   "
				+ "			de.id as idEncabezado  "
				+ "			,t.id as idTercero  "
				+ "			,sum(dmnd.valor_total_renglon) as bonificaNS     "
				+ "			from documento_movimiento_nomina dmn   "
				+ "			inner join documento_encabezado de on dmn.documento_encabezado_id  = de.id  and de.borrador = false  "
				+ "			inner join tercero t on dmn.tercero_id  = t.id and t.borrador =false  "
				+ "			inner join documento_movimiento_nomina_detalle dmnd on dmn.id = dmnd.documento_movimiento_nomina_id  and dmnd.borrador = false  "
				+ "			inner join nomina_concepto nc on dmnd.nomina_concepto_id = nc.id  and nc.borrador = false   "
				+ "			inner join homologa_codigo_dian hcd on nc.homologa_codigo_dian_id  = hcd.id  "
				+ "			where hcd.id = 10   " // -- in ('Bonex') -- Bonificacion Salarial  
				+ "			and dmn.borrador = false  "
				+ "			group by de.id ,t.id   "
				+ "         )tblBonificacionNS on t.id = tblBonificacionNS.idTercero and de.id = tblBonificacionNS.idEncabezado  "
				+ "left join(  "
				+ "			select   "
				+ "			de.id as idEncabezado  "
				+ "			,t.id as idTercero  "
				+ "			,sum(dmnd.valor_total_renglon) as auxilioNS     "
				+ "			from documento_movimiento_nomina dmn   "
				+ "			inner join documento_encabezado de on dmn.documento_encabezado_id  = de.id  and de.borrador = false  "
				+ "			inner join tercero t on dmn.tercero_id  = t.id and t.borrador =false  "
				+ "			inner join documento_movimiento_nomina_detalle dmnd on dmn.id = dmnd.documento_movimiento_nomina_id  and dmnd.borrador = false  "
				+ "			inner join nomina_concepto nc on dmnd.nomina_concepto_id = nc.id  and nc.borrador = false   "
				+ "			inner join homologa_codigo_dian hcd on nc.homologa_codigo_dian_id  = hcd.id  "
				+ "			where hcd.id = 11   " // -- in ('Auxal','Auxes','Auxro','Auxsl')    -- Auxilios no salariales  
				+ "			and dmn.borrador = false  "
				+ "			group by de.id ,t.id   "
				+ "         )tblAuxilioNS on t.id = tblAuxilioNS.idTercero and de.id = tblAuxilioNS.idEncabezado  "
				+ "left join(  "
				+ "			select   "
				+ "			de.id as idEncabezado  "
				+ "			,t.id as idTercero  "
				+ "			,sum(dmnd.valor_total_renglon) as conceptoNS     "
				+ "			from documento_movimiento_nomina dmn   "
				+ "			inner join documento_encabezado de on dmn.documento_encabezado_id  = de.id  and de.borrador = false  "
				+ "			inner join tercero t on dmn.tercero_id  = t.id and t.borrador =false  "
				+ "			inner join documento_movimiento_nomina_detalle dmnd on dmn.id = dmnd.documento_movimiento_nomina_id  and dmnd.borrador = false  "
				+ "			inner join nomina_concepto nc on dmnd.nomina_concepto_id = nc.id  and nc.borrador = false   "
				+ "			inner join homologa_codigo_dian hcd on nc.homologa_codigo_dian_id  = hcd.id  "
				+ "			where hcd.id = 12   " // -- in ('Otdvn')  -- Otros devengados  
				+ "			and dmn.borrador = false  "
				+ "			group by de.id ,t.id   "
				+ "         )tblConceptoNS on t.id = tblConceptoNS.idTercero and de.id = tblConceptoNS.idEncabezado  "
				+ "left join(  "
				+ "			select   "
				+ "			de.id as idEncabezado  "
				+ "			,t.id as idTercero  "
				+ "			,sum(dmnd.valor_total_renglon) as comision     "
				+ "			from documento_movimiento_nomina dmn   "
				+ "			inner join documento_encabezado de on dmn.documento_encabezado_id  = de.id  and de.borrador = false  "
				+ "			inner join tercero t on dmn.tercero_id  = t.id and t.borrador =false  "
				+ "			inner join documento_movimiento_nomina_detalle dmnd on dmn.id = dmnd.documento_movimiento_nomina_id  and dmnd.borrador = false  "
				+ "			inner join nomina_concepto nc on dmnd.nomina_concepto_id = nc.id  and nc.borrador = false   "
				+ "			inner join homologa_codigo_dian hcd on nc.homologa_codigo_dian_id  = hcd.id  "
				+ "			where hcd.id = 13   " // -- in ('Comis')  -- Comision  
				+ "			and dmn.borrador = false  "
				+ "			group by de.id ,t.id   "
				+ "         )tblComision on t.id = tblComision.idTercero and de.id = tblComision.idEncabezado  "
				+ "left join(  "
				+ "			select   "
				+ "			de.id as idEncabezado  "
				+ "			,t.id as idTercero  "
				+ "			,sum(dmnd.valor_total_renglon) as apoyoSost     "
				+ "			from documento_movimiento_nomina dmn   "
				+ "			inner join documento_encabezado de on dmn.documento_encabezado_id  = de.id  and de.borrador = false  "
				+ "			inner join tercero t on dmn.tercero_id  = t.id and t.borrador =false  "
				+ "			inner join documento_movimiento_nomina_detalle dmnd on dmn.id = dmnd.documento_movimiento_nomina_id  and dmnd.borrador = false  "
				+ "			inner join nomina_concepto nc on dmnd.nomina_concepto_id = nc.id  and nc.borrador = false   "
				+ "			inner join homologa_codigo_dian hcd on nc.homologa_codigo_dian_id  = hcd.id  "
				+ "			where hcd.id = 14   " // -- in ('CuoSo')  -- Apoyo a Sostenimiento  
				+ "			and dmn.borrador = false  "
				+ "			group by de.id ,t.id   "
				+ "         )tblApoyoSost on t.id = tblApoyoSost.idTercero and de.id = tblApoyoSost.idEncabezado  "
				+ "left join(  "
				+ "			select   "
				+ "			de.id as idEncabezado  "
				+ "			,t.id as idTercero  "
				+ "			,sum(dmnd.valor_total_renglon) as indemnizacion     "
				+ "			from documento_movimiento_nomina dmn   "
				+ "			inner join documento_encabezado de on dmn.documento_encabezado_id  = de.id  and de.borrador = false  "
				+ "			inner join tercero t on dmn.tercero_id  = t.id and t.borrador =false  "
				+ "			inner join documento_movimiento_nomina_detalle dmnd on dmn.id = dmnd.documento_movimiento_nomina_id  and dmnd.borrador = false  "
				+ "			inner join nomina_concepto nc on dmnd.nomina_concepto_id = nc.id  and nc.borrador = false   "
				+ "			inner join homologa_codigo_dian hcd on nc.homologa_codigo_dian_id  = hcd.id  "
				+ "			where hcd.id = 15   " // -- in ('Indem')  -- Indemnización  
				+ "			and dmn.borrador = false  "
				+ "			group by de.id ,t.id   "
				+ "         )tblIndemnizacion on t.id = tblIndemnizacion.idTercero and de.id = tblIndemnizacion.idEncabezado  "
				+ "left join(  "
				+ "			select   "
				+ "			de.id as idEncabezado  "
				+ "			,t.id as idTercero  "
				+ "			,(nc.factor_empleado)*100 as porcSalud  "
				+ "			,dmnd.valor_total_renglon as deducSalud  "
				+ "			from documento_movimiento_nomina dmn   "
				+ "			inner join documento_encabezado de on dmn.documento_encabezado_id  = de.id  and de.borrador = false  "
				+ "			inner join tercero t on dmn.tercero_id  = t.id and t.borrador =false  "
				+ "			inner join documento_movimiento_nomina_detalle dmnd on dmn.id = dmnd.documento_movimiento_nomina_id  and dmnd.borrador = false  "
				+ "			inner join nomina_concepto nc on dmnd.nomina_concepto_id = nc.id  and nc.borrador = false   "
				+ "			inner join homologa_codigo_dian hcd on nc.homologa_codigo_dian_id  = hcd.id  "
				+ "			where hcd.id = 16   " // -- in ('Aposa') --  Salud  
				+ "			and dmn.borrador = false  "
				+ "			and dmnd.responsable = 'TRAB'  "
				+ "         )tblSalud on t.id = tblSalud.idTercero and de.id = tblSalud.idEncabezado  "
				+ "left join(  "
				+ "			select   "
				+ "			de.id as idEncabezado  "
				+ "			,t.id as idTercero  "
				+ "			,(nc.factor_empleado)*100 as porcPension  "
				+ "			,dmnd.valor_total_renglon as deducPension  "
				+ "			from documento_movimiento_nomina dmn   "
				+ "			inner join documento_encabezado de on dmn.documento_encabezado_id  = de.id  and de.borrador = false  "
				+ "			inner join tercero t on dmn.tercero_id  = t.id and t.borrador =false  "
				+ "			inner join documento_movimiento_nomina_detalle dmnd on dmn.id = dmnd.documento_movimiento_nomina_id  and dmnd.borrador = false  "
				+ "			inner join nomina_concepto nc on dmnd.nomina_concepto_id = nc.id  and nc.borrador = false   "
				+ "			inner join homologa_codigo_dian hcd on nc.homologa_codigo_dian_id  = hcd.id  "
				+ "			where hcd.id = 17   " // -- in ('Apope') -- Pension  
				+ "			and dmn.borrador = false  "
				+ "			and dmnd.responsable = 'TRAB'  "
				+ "         )tblPension on t.id = tblPension.idTercero and de.id = tblPension.idEncabezado  "
				+ "left join(  "
				+ "			select   "
				+ "			de.id as idEncabezado  "
				+ "			,t.id as idTercero  "
				+ "			,nc.nombre as desLibranza  "
				+ "			,sum(dmnd.valor_total_renglon) as deduLibranza     "
				+ "			from documento_movimiento_nomina dmn   "
				+ "			inner join documento_encabezado de on dmn.documento_encabezado_id  = de.id  and de.borrador = false  "
				+ "			inner join tercero t on dmn.tercero_id  = t.id and t.borrador =false  "
				+ "			inner join documento_movimiento_nomina_detalle dmnd on dmn.id = dmnd.documento_movimiento_nomina_id  and dmnd.borrador = false  "
				+ "			inner join nomina_concepto nc on dmnd.nomina_concepto_id = nc.id  and nc.borrador = false   "
				+ "			inner join homologa_codigo_dian hcd on nc.homologa_codigo_dian_id  = hcd.id  "
				+ "			where hcd.id = 18   " // -- in ('Libra') -- Indemnización  
				+ "			and dmn.borrador = false  "
				+ "			group by de.id ,t.id,nc.nombre   "
				+ "         )tblLibranza on t.id = tblLibranza.idTercero and de.id = tblLibranza.idEncabezado  "
				+ "left join(  "
				+ "			select   "
				+ "			de.id as idEncabezado  "
				+ "			,t.id as idTercero  "
				+ "			,sum(dmnd.valor_total_renglon) as pagoTercero     "
				+ "			from documento_movimiento_nomina dmn   "
				+ "			inner join documento_encabezado de on dmn.documento_encabezado_id  = de.id  and de.borrador = false  "
				+ "			inner join tercero t on dmn.tercero_id  = t.id and t.borrador =false  "
				+ "			inner join documento_movimiento_nomina_detalle dmnd on dmn.id = dmnd.documento_movimiento_nomina_id  and dmnd.borrador = false  "
				+ "			inner join nomina_concepto nc on dmnd.nomina_concepto_id = nc.id  and nc.borrador = false   "
				+ "			inner join homologa_codigo_dian hcd on nc.homologa_codigo_dian_id  = hcd.id  "
				+ "			where hcd.id = 19   " // -- in ('Fonah','Medic','Segvi') -- PagoTercero  
				+ "			and dmn.borrador = false  "
				+ "			group by de.id ,t.id   "
				+ "         )tblPagoTercero on t.id = tblPagoTercero.idTercero and de.id = tblPagoTercero.idEncabezado  "
				+ "left join(  "
				+ "			select   "
				+ "			de.id as idEncabezado  "
				+ "			,t.id as idTercero  "
				+ "			,sum(dmnd.valor_total_renglon) as anticipo     "
				+ "			from documento_movimiento_nomina dmn   "
				+ "			inner join documento_encabezado de on dmn.documento_encabezado_id  = de.id  and de.borrador = false  "
				+ "			inner join tercero t on dmn.tercero_id  = t.id and t.borrador =false  "
				+ "			inner join documento_movimiento_nomina_detalle dmnd on dmn.id = dmnd.documento_movimiento_nomina_id  and dmnd.borrador = false  "
				+ "			inner join nomina_concepto nc on dmnd.nomina_concepto_id = nc.id  and nc.borrador = false   "
				+ "			inner join homologa_codigo_dian hcd on nc.homologa_codigo_dian_id  = hcd.id  "
				+ "			where hcd.id = 20   " // -- in ('Antci') -- PagoTercero  
				+ "			and dmn.borrador = false  "
				+ "			group by de.id ,t.id   "
				+ "         )tblAnticipo on t.id = tblAnticipo.idTercero and de.id = tblAnticipo.idEncabezado  "
				+ "left join(  "
				+ "			select   "
				+ "			de.id as idEncabezado  "
				+ "			,t.id as idTercero  "
				+ "			,sum(dmnd.valor_total_renglon) as pensionVoluntaria     "
				+ "			from documento_movimiento_nomina dmn   "
				+ "			inner join documento_encabezado de on dmn.documento_encabezado_id  = de.id  and de.borrador = false  "
				+ "			inner join tercero t on dmn.tercero_id  = t.id and t.borrador =false  "
				+ "			inner join documento_movimiento_nomina_detalle dmnd on dmn.id = dmnd.documento_movimiento_nomina_id  and dmnd.borrador = false  "
				+ "			inner join nomina_concepto nc on dmnd.nomina_concepto_id = nc.id  and nc.borrador = false  "
				+ "			inner join homologa_codigo_dian hcd on nc.homologa_codigo_dian_id  = hcd.id  "
				+ "			where hcd.id = 21   " // -- in ('Apfpn','Apfpo')  -- Aportes Pension voluntaria  
				+ "			and dmn.borrador = false  "
				+ "			group by de.id ,t.id   "
				+ "         )tblFondoPension on t.id = tblFondoPension.idTercero and de.id = tblFondoPension.idEncabezado  "
				+ "left join(  "
				+ "			select   "
				+ "			de.id as idEncabezado  "
				+ "			,t.id as idTercero  "
				+ "			,sum(dmnd.valor_total_renglon) as afc     "
				+ "			from documento_movimiento_nomina dmn   "
				+ "			inner join documento_encabezado de on dmn.documento_encabezado_id  = de.id  and de.borrador = false  "
				+ "			inner join tercero t on dmn.tercero_id  = t.id and t.borrador =false  "
				+ "			inner join documento_movimiento_nomina_detalle dmnd on dmn.id = dmnd.documento_movimiento_nomina_id  and dmnd.borrador = false  "
				+ "			inner join nomina_concepto nc on dmnd.nomina_concepto_id = nc.id  and nc.borrador = false   "
				+ "			inner join homologa_codigo_dian hcd on nc.homologa_codigo_dian_id  = hcd.id  "
				+ "			where hcd.id = 22   " // -- in ('Apafc') Corresponde a (Ahorro Fomento a la contruccion)  
				+ "			and dmn.borrador = false  "
				+ "			group by de.id ,t.id   "
				+ "         )tblAhorrCons on t.id = tblAhorrCons.idTercero and de.id = tblAhorrCons.idEncabezado     "
				+ "left join(  "
				+ "			select   "
				+ "			de.id as idEncabezado  "
				+ "			,t.id as idTercero  "
				+ "			,sum(dmnd.valor_total_renglon) as deuda     "
				+ "			from documento_movimiento_nomina dmn   "
				+ "			inner join documento_encabezado de on dmn.documento_encabezado_id  = de.id  and de.borrador = false  "
				+ "			inner join tercero t on dmn.tercero_id  = t.id and t.borrador =false  "
				+ "			inner join documento_movimiento_nomina_detalle dmnd on dmn.id = dmnd.documento_movimiento_nomina_id  and dmnd.borrador = false  "
				+ "			inner join nomina_concepto nc on dmnd.nomina_concepto_id = nc.id  and nc.borrador = false   "
				+ "			inner join homologa_codigo_dian hcd on nc.homologa_codigo_dian_id  = hcd.id  "
				+ "			where hcd.id = 23   " // -- in ('Prést') -- Corresponde a (Ahorro Fomento a la contruccion)  
				+ "			and dmn.borrador = false  "
				+ "			group by de.id ,t.id   "
				+ "         )tblPrestamos on t.id = tblPrestamos.idTercero and de.id = tblPrestamos.idEncabezado  "
				+ "where de.fecha between '2022-07-01 00:00:00.000' and '2022-07-31 23:59:59.999' "
				+ "and def.fecha  between '2022-07-01 00:00:00.000' and '2022-07-31 23:59:59.999' "
				+ "and def.fecha  < current_date      "
				+ "and dmn.contrato_id is not null  "
				+ ")t                  "
				+ "group by t.idTercero  "
				+ ",t.FechaIngreso  "
				+ ",t.CodigoTrabajadorA  "
				+ ",t.Pais   "
				+ ",t.DepartamentoEstado   "
				+ ",t.MunicipioCiudad   "
				+ ",t.Idioma   "
				+ ",t.TipoMoneda   "
				+ ",t.RazonSocial  "
				+ ",t.NIT   "
				+ ",t.DV   "
				+ ",t.PaisEmpl  "
				+ ",t.DepartamentoEstadoEmpl  "
				+ ",t.MunicipioCiudadEmpl  "
				+ ",t.direccion   "
				+ ",t.TipoTrabajador   "
				+ ",t.SubTipoTrabajador  "
				+ ",t.AltoRiesgoPension   "
				+ ",t.TipoDocumento   "
				+ ",t.NumeroDocumento   "
				+ ",t.PrimerApellido  "
				+ ",t.SegundoApellido   "
				+ ",t.PrimerNombre  "
				+ ",t.OtrosNombres  "
				+ ",t.LugarTrabajoPais  "
				+ ",t.LugarTrabajoDepartamentoEstado  "
				+ ",t.LugarTrabajoMunicipioCiudad   "
				+ ",t.LugarTrabajoDireccion   "
				+ ",t.idcontrato   "
				+ ",t.SalarioIntegral   "
				+ ",t.TipoContrato  "
				+ ",t.CodigoTrabajadorB  "
				+ ",t.Banco   "
				+ ",t.TipoCuenta  "
				+ ",t.NumeroCuenta   "
				+ ",t.Correo  "
				+ ",t.Centro_Trabajo  "
				+ ",t.Cargo_Empleado  "
				+ ")w  "
				+ "order by w.idTercero desc   ";

		// String regex="(join(\s*)\\()";

		String sqlTemp = "from (select ) ";

		String regex = "(join|JOIN)(\\s+)([a-zA-z]+)";

		String esquema = "\"kggfhdqbyydracrsckfd\"";

		//sqlTemp = replaceAll(sqlTemp, "from", " from " + esquema + ".");

		sql = sql.replaceAll(regex, " join " + esquema + ".$3");
		
		String regexFrom = ("(from|FROM)(\\s+)([a-zA-z]+)");
		
		sql = sql.replaceAll(regexFrom, " from " + esquema + ".$3");

		System.out.println(sql);

	}

	private static String replaceAll(String texto, String regex, String replacement) {
		texto = texto.replaceAll(regex, replacement).replaceAll(regex.toUpperCase(), replacement);
		return texto;
	}

	public static void generarUpdate() throws Exception {

		List<String> listString = null;

		try (var io = Files.lines(Paths.get("D:\\TrabajoWorlOffice\\TAREAS\\UpdatePrueba.txt"))) {

			listString = io.map(x -> {
				x = x.replace("public.", "");
				if (x.startsWith("SET")) {
					int index = x.indexOf("codigo_tipo_identificacion_dian");
					int indexFin = x.indexOf(",", index);

					return "SET " + x.substring(index, indexFin);
				}
				return x;
			}).collect(Collectors.toList());

		}

		try (var os = new BufferedWriter(new FileWriter("D:\\TrabajoWorlOffice\\TAREAS\\UpdatePruebaFinal.txt"))) {

			for (String line : listString) {
				os.write(line);
				os.newLine();
			}

		}

	}

	public static void calcularInsertMuni() throws Exception {

		var listInsert = Files
				.readAllLines(Paths.get("D:/TrabajoWorlOffice/TAREAS/Resolucion/BuildCodMunicipios/insertMuni.txt"));

		var listExcel = Files.readAllLines(
				Paths.get("D:/TrabajoWorlOffice/TAREAS/Resolucion/BuildCodMunicipios/CalculoDiferencias.txt"));

		var listResultados = new ArrayList<String>();

		LABEL_INSERT: for (String x : listInsert) {

			String[] datos = x.split(",");

			String codigoDepartamento = datos[2].trim().toLowerCase();
			String nombreMunicio = stripAccents(datos[1]).toLowerCase().trim().replaceAll(" +", " ");

			// System.out.println("========"+codigoDepartamento+","+nombreMunicio+" vs:");

			for (String strLine : listExcel) {
				String[] datosExcel = strLine.split(",");

				String codigoDepartamentoExcel = datosExcel[0].trim().toLowerCase();
				String nombreMunicipioExcel = stripAccents(datosExcel[3]).toLowerCase().trim().replaceAll(" +", " ");

				// System.out.println("codigoDepartamentoExcel:"+codigoDepartamentoExcel+",nombreMunicipioExcel:"+nombreMunicipioExcel);

				if (codigoDepartamento.equals(codigoDepartamentoExcel) && nombreMunicio.equals(nombreMunicipioExcel)) {

					// System.out.println(x+","+datosExcel[1]);

					listResultados.add(x + "," + datosExcel[1]);

					continue LABEL_INSERT;
				}
			}

			// System.out.println(x+", nada");

			listResultados.add(x + ",null");
		}

		try (var ou = new BufferedWriter(
				new FileWriter("D:/TrabajoWorlOffice/TAREAS/Resolucion/BuildCodMunicipios/Resultado.txt"))) {

			int cantidadNull = 0;
			for (String x : listResultados) {

				if (x.contains("null")) {
					cantidadNull += 1;
				}

				ou.write(x);
				ou.newLine();
			}

			System.out.println("nulos: " + cantidadNull);
		}

	}

	public static void crearInsertParaDatabasePopulator() throws Exception {

		try (var is = new BufferedReader(
				new FileReader("D:/TrabajoWorlOffice/TAREAS/Resolucion/BuildCodMunicipios/ResultadoManual.txt"));
				var io = new BufferedWriter(new FileWriter(
						"D:/TrabajoWorlOffice/TAREAS/Resolucion/BuildCodMunicipios/ResultadoToDataBasePopulator.txt"))) {

			String line = null;

			while ((line = is.readLine()) != null) {

				String[] datos = line.split(",");

				String codigoDian = datos[3] != null && (!datos[3].trim().equalsIgnoreCase("null"))
						? "\"" + datos[3] + "\""
						: null;

				String resultado = "crearUbicacionCiudad(\"" + datos[0].trim() + "\",\"" + datos[1].trim() + "\",\""
						+ datos[2].trim() + "\"," + codigoDian + ");";
				io.write(resultado);
				io.newLine();
			}

		}

	}

	public static String stripAccents(String s) {
		s = Normalizer.normalize(s, Normalizer.Form.NFD);
		s = s.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
		return s;
	}

}
