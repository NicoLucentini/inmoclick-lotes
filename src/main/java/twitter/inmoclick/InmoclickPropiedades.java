package twitter.inmoclick;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InmoclickPropiedades implements Serializable {

    //public List<InmoclickPropiedad> propiedades = new ArrayList<InmoclickPropiedad>();

    public Map<String, InmoclickPropiedad> propiedades = new HashMap<String, InmoclickPropiedad>();
    public InmoclickPropiedades(){}
}