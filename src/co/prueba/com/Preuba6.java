package co.prueba.com;


public class Preuba6 {
	
	private static String strCompleto = """
			SELECT DISTINCT de1_0.id,
                de1_0.borrador,
                de1_0.concepto,
                de1_0.creado_por,
                de1_0.documento_asociado_id,
                de1_0.documento_motivos_generacion_id,
                de1_0.documento_tipo_id,
                de1_0.empresa_id,
                de1_0.fecha,
                de1_0.fecha_creacion,
                de1_0.fecha_modificacion,
                de1_0.forma_pago_id,
                de1_0.liquidacion_contabilizada,
                de1_0.liquidacion_pagada,
                de1_0.modificado_por,
                de1_0.moneda_id,
                de1_0.nomina_prestaciones_encabezado_id,
                de1_0.numero,
                de1_0.numero_externo,
                de1_0.prefijo_id,
                de1_0.prefijo_externo,
                de1_0.sen_contabilizado,
                de1_0.sen_cuadrado,
                de1_0.sen_generado,
                de1_0.sen_generado_por_liquidacion_contrato,
                de1_0.sen_liquidacion,
                de1_0.sen_reliquidacion,
                de1_0.tenant_id,
                de1_0.tercero_direccion_id,
                de1_0.tercero_externo_id,
                de1_0.tercero_interno_id,
                de1_0.terminal_pos_id,
                de1_0.total_encabezado,
                de1_0.trm,
                de1_0.turno_id,
                de1_0.version,
                de1_1.documento_reoluciones,
                de1_2.documento_tipo_nota_credito
FROM            "zckuhkmwadcbqwgedzgt".documento_cruce_inventario dci1_0
JOIN            "zckuhkmwadcbqwgedzgt".documento_movimiento_inventario dmi1_0 ON  dmi1_0.id=dci1_0.documento_movimiento_inventario_id
JOIN            (documento_encabezado de1_0
LEFT JOIN       "zckuhkmwadcbqwgedzgt".documento_resoluciones_documento de1_1
ON              de1_0.id=de1_1.documento_encabezado
LEFT JOIN       "zckuhkmwadcbqwgedzgt".documento_encabezado_tipo_nota_credito de1_2
ON              de1_0.id=de1_2.documento_encabezado)
ON              de1_0.id=dmi1_0.documento_encabezado_id
JOIN            "zckuhkmwadcbqwgedzgt".documento_movimiento_inventario dmio1_0
ON              dmio1_0.id=dci1_0.documento_movimiento_inventario_origen_id
WHERE           (
                                dci1_0.tenant_id = 2
                OR              dci1_0.tenant_id = -1)
AND             dci1_0.borrador = false
AND             dmio1_0.documento_encabezado_id=80486
AND             dci1_0.documento_movimiento_inventario_origen_id<>dci1_0.documento_movimiento_inventario_id
			""";
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	
	String sql = strCompleto.replaceAll("(join|JOIN)(\\s+)\\((documento_encabezado(\\s+))", "JOIN "+" (\"zckuhkmwadcbqwgedzgt\".documento_encabezado ");
	System.out.println(sql);
	

	}


}
