package symmetrical.cosmic._physics._subatomic.matter.bosons

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.balanced.Particle
import symmetrical.cosmic._physics._subatomic.balanced.values.Field
import symmetrical.cosmic._physics._subatomic.forces.weak_force.Weak
import symmetrical.cosmic._physics._subatomic.spatial.ParticleBeam


open class ZBoson : Particle, Weak {
    object Illuminations {
        public val beam: ParticleBeam = ParticleBeam()
    }
    // Neutral Charge
    // Spin 1
    // This boson transfers its spin, momentum and energy

 //   var result:Any? = null

    private var accepted     :Boolean   = true
    private var constructing :Boolean   = false
    private var newValue     :Field     = Field();
    private var oldValue     :Field     = Field()
    private var reasonCode   :Int       = 0
    private var reason       :String    = ""

    constructor() {
    }

    public override fun getIlluminations() : ParticleBeam {
        return Illuminations.beam
    }
    private fun getLocalClassId() : String {
        return Absorber.getClassId(ZBoson::class)
    }
    override fun getClassId() : String {
        return getLocalClassId()
    }
    fun i(newValue: Field, constructing:Boolean = false) : ZBoson {
        return this
    }
}