package asymmetrical.wormholes.pulsar.nebula_phases

import symmetrical.cosmic.cosmology.INebula
import symmetrical.cosmic.cosmology.NebulaPhase


/*
5. Planetary nebulae are formed when a star at the end of its life expands and casts off its outer layers of gas. The gas forms a shell around the star, which eventually disperses into space.
 */
class PlanetaryNebula: NebulaPhase, INebula {

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