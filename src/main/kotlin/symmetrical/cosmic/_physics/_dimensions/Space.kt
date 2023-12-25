package symmetrical.cosmic._physics._dimensions

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.balanced.IParticle
import symmetrical.cosmic._physics._subatomic.balanced.values.Field
import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics._subatomic.luminescent.AntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.IAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.IQuantumField
import symmetrical.cosmic._physics._subatomic.luminescent.QuantumField

class Space (private val field: QuantumField = QuantumField()) : IQuantumField by field {

    private var space: IParticle? = null   // this may have to change to a Particle UniqueId when emitted

    constructor() : this(
        QuantumField()
    )
    fun i() : Space {
        return this
    }
    override fun absorb(photon: Photon) : Photon {
        return field.absorb(photon.propagate());
    }
    override fun emit() : Photon {
        return Photon(radiate())
    }
    public fun getClassId() : String {
        return getLocalClassId()
    }
    fun getField() : Field {
        return field.getField()
    }
    fun getSpace() : IParticle? {
        return space
    }
    fun setSpace(particle:IParticle) : Any? {
        this.space = particle
        return setValue(particle.createUniqueId().getUniqueId())
    }
    fun space() : Any? {
        return field.getValue()
    }
    private fun getLocalClassId() : String {
        return Absorber.getClassId(Space::class)
    }
    private fun radiate() : String {
        return getLocalClassId()+field.emit().radiate()
    }
}