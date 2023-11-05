package asymmetrical.wormholes.pulsar.plugins.http.wormhole.fields

import symmetrical.cosmic._physics.atomic.atoms.states.strings.QString
import symmetrical.cosmic._physics.atomic.substance.ions.Compound
import symmetrical.cosmic.wormholes.pulsar.dictionary.Path


class RequestMethod : Compound {
    object Static {
        const val METHOD    : Int = Compound.Static.LAST+1
        const val URL       : Int = Compound.Static.LAST+2
        const val PROTOCOL  : Int = Compound.Static.LAST+3

        const val LAST      : Int = PROTOCOL
    }
    constructor(value:String)  {
        val tokens              = value.split(" ")
        add(QString(tokens[0]))
        add(Path(tokens[1]))
        add(QString(tokens[2]))
        shrink()
    }

    fun getRequestMethod() : QString {
        return get(Static.METHOD) as QString
    }
    fun getPath() : Path {
        return get(Static.URL) as Path
    }

    fun getProtocol() : QString {
        return get(Static.PROTOCOL) as QString
    }
}