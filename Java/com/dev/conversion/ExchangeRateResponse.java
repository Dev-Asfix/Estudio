package com.dev.conversion;
package com.dev.converion;

import com.google.gson.annotations.SerializedName;

public record ExchangeRateResponse(
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
) {}
