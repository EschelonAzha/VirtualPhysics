package asymmetrical.wormholes.pulsar.plugins.http.director.inspectors

import asymmetrical.wormholes.pulsar.plugins.http.HttpInspector


class HomePage : HttpInspector {
    constructor() : super() {
    }

    override fun inspect() : Int {
        if (method.quarkValue().toString().lowercase() != "get")
            return 0
        getPayload().add("")
        if (path.isEmpty())
            return 1
        return 0
    }
}