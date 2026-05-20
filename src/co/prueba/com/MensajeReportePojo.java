package co.prueba.com;

import java.util.List;

public class MensajeReportePojo {

	private List<Long> listIdsDocEnca;
	private String email;
	private String codigoReporte;
	private String nombreSubject;
	private String esquema;
	private String emailAccion;
	private String timeZone;
	private String token;
	private Long tenantAutenticadoId;
	private Boolean suscripcionActiva;
	private Boolean licenciaVencida;
	private Boolean costoPromedio;
	private Long idUsuario;

	public List<Long> getListIdsDocEnca() {
		return listIdsDocEnca;
	}

	public void setListIdsDocEnca(List<Long> listIdsDocEnca) {
		this.listIdsDocEnca = listIdsDocEnca;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCodigoReporte() {
		return codigoReporte;
	}

	public void setCodigoReporte(String codigoReporte) {
		this.codigoReporte = codigoReporte;
	}

	public String getNombreSubject() {
		return nombreSubject;
	}

	public void setNombreSubject(String nombreSubject) {
		this.nombreSubject = nombreSubject;
	}

	public String getEsquema() {
		return esquema;
	}

	public void setEsquema(String esquema) {
		this.esquema = esquema;
	}

	public String getEmailAccion() {
		return emailAccion;
	}

	public void setEmailAccion(String emailAccion) {
		this.emailAccion = emailAccion;
	}

	public String getTimeZone() {
		return timeZone;
	}

	public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
	public Long getTenantAutenticadoId() {
		return tenantAutenticadoId;
	}

	public void setTenantAutenticadoId(Long tenantAutenticadoId) {
		this.tenantAutenticadoId = tenantAutenticadoId;
	}

	public Boolean getSuscripcionActiva() {
		return suscripcionActiva;
	}

	public void setSuscripcionActiva(Boolean suscripcionActiva) {
		this.suscripcionActiva = suscripcionActiva;
	}

	public Boolean getLicenciaVencida() {
		return licenciaVencida;
	}

	public void setLicenciaVencida(Boolean licenciaVencida) {
		this.licenciaVencida = licenciaVencida;
	}

	public Boolean getCostoPromedio() {
		return costoPromedio;
	}

	public void setCostoPromedio(Boolean costoPromedio) {
		this.costoPromedio = costoPromedio;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}	
	
}
