package asymmetrical.machine.vm.remote_terminal

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.dom.dom.Body

class RemotePage : Body {
    constructor() {

    }
    override fun absorb(photon: Photon) : Photon {
        return super.absorb(photon.propagate())
    }
    override fun emit() : Photon {
        return Photon(radiate())
    }
    private fun getLocalClassId() : String {
        return Absorber.getClassId(RemotePage::class)
    }
    private fun radiate() : String {
        return getLocalClassId()+super.emit().radiate()
    }
}