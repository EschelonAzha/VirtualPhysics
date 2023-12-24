package asymmetrical.wormholes.pulsar.nebula_phases

import symmetrical.cosmic.cosmology.INebula
import symmetrical.cosmic.cosmology.NebulaPhase

/*
2. Reflection nebulae are formed when light from nearby stars is scattered by the dust in a dark nebula. The dust grains in a reflection nebula are typically much smaller than the grains in a dark nebula, so they scatter the light more effectively.
 */
class ReflectionNebula : NebulaPhase, INebula {

    constructor(parent:INebula) : super(parent) {
    }
    override fun nextPhase() : INebula {
        return this
    }
    override fun onClose  ()                 : Unit {
    }
    override fun onMessage(message:String)   : Boolean {
        return true
    }
    override fun onOpen   ()                 : Unit {
    }
}