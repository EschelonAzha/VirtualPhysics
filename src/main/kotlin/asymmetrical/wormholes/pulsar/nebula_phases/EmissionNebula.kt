package asymmetrical.wormholes.pulsar.nebula_phases

import symmetrical.cosmic.cosmology.INebula
import symmetrical.cosmic.cosmology.NebulaPhase


/*
3. Emission nebulae are formed when the gas in a nebula is ionized by the radiation from nearby stars. The ionized gas emits light of its own, which is why emission nebulae are often bright and colorful.
 */
open class EmissionNebula: NebulaPhase, INebula {

    constructor(parent:INebula) : super(parent) {
    }
    override fun nextPhase() : INebula {
        return this
    }
    override fun onOpen   ()                 : Unit {

    }
    override fun onClose  ()                 : Unit {

    }
    override fun onMessage(message:String)   : Boolean {
        return true
    }
}