package symmetrical.cosmic._physics._subatomic.bosons

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.matter.hadrons.mesons.PlusPion
import symmetrical.cosmic._physics._subatomic.matter.colors.Color
import symmetrical.cosmic._physics._subatomic.anti_matter.anti_colors.AntiColor
import symmetrical.cosmic._physics._subatomic.balanced.Particle
import symmetrical.cosmic._physics._subatomic.matter.colors.Green
import symmetrical.cosmic._physics._subatomic.spatial.ParticleBeam
import symmetrical.cosmic.wormholes.messaging.entanglement.IQuantumEntanglement
import symmetrical.cosmic.wormholes.messaging.entanglement.QuantumEntanglement

// Transformations are in Gluons and use different mixtures of colors to accomplish anything
// for example AND and OR and XOR
open class Gluon(private val entanglement:QuantumEntanglement=QuantumEntanglement()) : Particle(), IQuantumEntanglement by entanglement  {

    // Gluons are confined within
    // Spin 1
    lateinit var color      : Color
    lateinit var antiColor  : AntiColor

    var manifestation : Green = Green()

    constructor() : this(QuantumEntanglement()) {
    }

    private fun getLocalClassId() : String {
        return Absorber.getClassId(Gluon::class)
    }
    override fun getClassId() : String {
        return getLocalClassId()
    }
    open fun i() : Gluon {
        return this
    }
    open fun getAntiValue() : Any? {
        return antiColor._value
    }
    fun setGreen(green: Green) : Gluon {
        this.manifestation = green
        return this
    }
    open fun setValue(value:Any?) : Gluon {
        color.setValue(value)
        antiColor.setValue(value)

        return this
    }
    fun exchange() : PlusPion {
        // incomplete.  My thinking is that value will be
        // reflected in Neutrons that are inert
        // get the new value, then become charged (proton)
        // then transmit their charges to the value proton
        // then become Neutrons again.  (Not sure if this is necessary
        // but something to think about.


        var pion = PlusPion() // pull quarks from the vacuum
//        pion.quarks[0].gluon.setValue(color.value)
//
//        color.value = antiColor.value
        return pion
    }

    fun green() : Green {
        return manifestation.clone()
    }
}