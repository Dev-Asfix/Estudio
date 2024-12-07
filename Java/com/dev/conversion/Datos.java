/**
 * @author Pablo Rosas Ramirez
 * @version 1.0
 * @since 2024-10-29
 */

package com.dev.conversion;

import com.google.gson.annotations.SerializedName;

public record Datos(
        //Serializamos
        @SerializedName("result") String resultado,
        @SerializedName("documentation") String documentacion,
        @SerializedName("terms_of_use") String terminosDeUso,
        @SerializedName("time_last_update_unix") long tiempoUltimaActualizacionUnix,
        @SerializedName("time_last_update_utc") String tiempoUltimaActualizacionUtc,
        @SerializedName("time_next_update_unix") long tiempoProximaActualizacionUnix,
        @SerializedName("time_next_update_utc") String tiempoProximaActualizacionUtc,
        @SerializedName("base_code") String codigoBase,
        @SerializedName("target_code") String codigoObjetivo,
        @SerializedName("conversion_rate") double tasaDeConversion,
        @SerializedName("conversion_result") double resultadoConversion
        
/*2935 8004 
4217 6699
5390 2388
5657 0976
5826 4256
--> Ok*/

/*
2702 7453
8198 3638
7371 6100
7594 7081
9917 5540
0065 9952
4354 6106
0966 2140
9977 1208
3468 0242
il*/

/*
2627 8280
5545 0982
8932 6837
1847 6686
1409 0963
7431 3161
7228 6270
9252 0664
8232 7375
0324 5838
dev-as
*/
) {}
