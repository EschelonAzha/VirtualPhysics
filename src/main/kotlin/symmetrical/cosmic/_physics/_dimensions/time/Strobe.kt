package symmetrical.cosmic._physics._dimensions.time

import asymmetrical.machine.time.RequestAnimationFrame
import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._creation.Universe
import symmetrical.cosmic._physics._subatomic.spatial.ParticleBeam

class Strobe {
    object Illuminations {
        public val beam: ParticleBeam = ParticleBeam()
    }
    private val requestAnimationFrame = RequestAnimationFrame().i(this)

    constructor() {
    }
    public fun getIlluminations() : ParticleBeam {
        return Illuminations.beam
    }
    private fun getLocalClassId() : String {
        return Absorber.getClassId(symmetrical.cosmic._physics._dimensions.time.Strobe::class)
    }
    open fun getClassId() : String {
        return getLocalClassId()
    }
    fun i() : symmetrical.cosmic._physics._dimensions.time.Strobe {
        return this
    }
    fun frame(timestamp:Double): Unit {
        return
    }
    fun start() : symmetrical.cosmic._physics._dimensions.time.Strobe {
        requestAnimationFrame.start()
        return this
    }
}