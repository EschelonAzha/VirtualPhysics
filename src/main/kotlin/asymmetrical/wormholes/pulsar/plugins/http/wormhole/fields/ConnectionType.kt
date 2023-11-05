package asymmetrical.wormholes.pulsar.plugins.http.wormhole.fields

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics.atomic.atoms.states.strings.QString
import symmetrical.cosmic.chemistry.diatomics.KeyValue

class ConnectionType : KeyValue {
    constructor() : super() {
    }
    constructor(key: QString, value: QString) : super(key, value) {
    }
    override fun absorb(photon: Photon) : Photon {
        return super.absorb(photon.propagate())
    }

    override fun emit() : Photon {
        return Photon(radiate())
    }
    private fun radiate() : String {
        return getLocalClassId()+super.emit().radiate()
    }
    private fun getLocalClassId() : String {
        return Absorber.getClassId(ConnectionType::class)
    }
}