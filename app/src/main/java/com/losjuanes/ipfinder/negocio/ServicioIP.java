package com.losjuanes.ipfinder.negocio;

import android.content.Context;

/**
 * Created by josec on 05/03/2017.
 */

public interface ServicioIP {

    ModeloCubiculo buscarIP(Context context, String ip);
}
