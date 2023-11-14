package symmetrical.cosmic._physics._creation

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._bitmaps.Bits64
import symmetrical.cosmic._physics._subatomic.spatial.ParticleBeam
import symmetrical.cosmic.wormholes.messaging.entanglement.IQuantumEntanglement
import symmetrical.cosmic.wormholes.messaging.entanglement.QuantumEntanglement

open class Universe (private val entanglement:QuantumEntanglement=QuantumEntanglement()):IQuantumEntanglement by entanglement {

    constructor() : this(QuantumEntanglement()) {
        println("Universe Created!")
    }

    private fun getLocalClassId() : String {
        return Absorber.getClassId(symmetrical.cosmic._physics._creation.Universe::class)
    }
    open fun getClassId() : String {
        return getLocalClassId()
    }
    fun i() : symmetrical.cosmic._physics._creation.Universe {
       return this
    }
    open fun run() {
//        while (true) {
//            Energy.sleep(4)
//        }
    }
}