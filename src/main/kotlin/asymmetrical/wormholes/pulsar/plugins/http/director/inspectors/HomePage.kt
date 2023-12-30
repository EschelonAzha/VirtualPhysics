package asymmetrical.wormholes.pulsar.plugins.http.director.inspectors

import asymmetrical.wormholes.pulsar.plugins.http.HttpInspector
import symmetrical.cosmic._physics._subatomic.balanced.fundamentals.wavelength.Wavelength
import symmetrical.cosmic._physics._subatomic.matter.hadrons.baryons.Proton
import symmetrical.cosmic._physics._subatomic.matter.quarks.Quark
import symmetrical.cosmic.dictionary.protons.ValueProton


class HomePage : HttpInspector {
    constructor() : super() {
    }

    override fun inspect() : Int {
        val content: String = Wavelength.field(method).toString()
        if (content.lowercase() != "get")
            return 0
        getPayload().add("")
        if (path.isEmpty())
            return 1
        return 0
    }
}