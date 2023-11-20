package symmetrical.cosmic._physics._dimensions.time

import asymmetrical.machine.time.RequestAnimationFrame
import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.fermions.IQuantumEntanglement
import symmetrical.cosmic._physics._subatomic.fermions.QuantumEntanglement

class Strobe (
    private val fermion: IQuantumEntanglement = QuantumEntanglement(),

    ) :
    IQuantumEntanglement by fermion
{
    constructor() : this(
        QuantumEntanglement()
    )

    private val requestAnimationFrame = RequestAnimationFrame().i(this)

    private fun getLocalClassId() : String {
        return Absorber.getClassId(Strobe::class)
    }
    open fun getClassId() : String {
        return getLocalClassId()
    }
    fun i() : Strobe {
        return this
    }
    fun frame(timestamp:Double): Unit {
        return
    }
    fun start() : Strobe {
        requestAnimationFrame.start()
        return this
    }
}