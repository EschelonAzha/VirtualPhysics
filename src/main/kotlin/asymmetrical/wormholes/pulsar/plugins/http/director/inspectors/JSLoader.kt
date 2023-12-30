package asymmetrical.wormholes.pulsar.plugins.http.director.inspectors


import asymmetrical.wormholes.pulsar.plugins.http.HttpInspector
import symmetrical.cosmic._physics._subatomic.balanced.fundamentals.wavelength.Wavelength
import symmetrical.cosmic._physics._subatomic.matter.hadrons.baryons.Proton
import symmetrical.cosmic._physics._subatomic.matter.quarks.Quark
import symmetrical.cosmic._physics.atomic.atoms.states.strings.QString
import symmetrical.cosmic.dictionary.protons.ValueProton

class JSLoader : HttpInspector {
    constructor() : super() {
    }
    override fun inspect() : Int {
        var content: String = Wavelength.field(method).toString()
        if (content.lowercase() != "get")
            return 0
        getPayload().add("")

        val file  = Wavelength.field(path.get(0) as QString).toString()
        if (file.endsWith(".js"))
            return 1
        return 0
    }
    fun inspectx() : Int {
        var proton : Proton = method.getProton(ValueProton::class)
        var quark  : Quark = proton.getValue()
        var content: String = quark.wavelength().toString()
        if (content.lowercase() != "get")
            return 0
        getPayload().add("")

        val qString   : QString = path.get(0) as QString
        proton  = qString.getProton(ValueProton::class)
        quark   = proton.getValue()
        val file  = quark.wavelength().toString()
        if (file.endsWith(".js"))
            return 1
        return 0
    }
}
