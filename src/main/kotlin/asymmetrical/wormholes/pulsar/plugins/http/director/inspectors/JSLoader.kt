package asymmetrical.wormholes.pulsar.plugins.http.director.inspectors


import asymmetrical.wormholes.pulsar.plugins.http.HttpInspector
import symmetrical.cosmic._physics.atomic.atoms.states.strings.QString

class JSLoader : HttpInspector {
    constructor() : super() {

    }

    override fun inspect() : Int {
        if (method.quarkValueStr().lowercase() != "get")
            return 0
        getPayload().add("")
        val file = (path.get(0) as QString).quarkValueStr()

        if (file.endsWith(".js"))
            return 1
        return 0
    }

}
