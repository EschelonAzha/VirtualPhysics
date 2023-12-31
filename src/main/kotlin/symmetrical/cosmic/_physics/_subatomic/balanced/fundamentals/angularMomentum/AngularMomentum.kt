package symmetrical.cosmic._physics._subatomic.balanced.fundamentals.angularMomentum

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.balanced.fundamentals.wavelength.Wavelength
import symmetrical.cosmic._physics._subatomic.balanced.values.Field
import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics._subatomic.luminescent.IQuantumField
import symmetrical.cosmic._physics._subatomic.luminescent.QuantumField
import symmetrical.cosmic._physics._subatomic.matter.hadrons.baryons.Proton
import symmetrical.cosmic._physics._subatomic.matter.quarks.Quark
import symmetrical.cosmic._physics.atomic.atoms.Atom
import symmetrical.cosmic.dictionary.protons.ValueProton
import kotlin.reflect.KClass

open class AngularMomentum(
    private val field: QuantumField = QuantumField()
) :
    IQuantumField by field
{

    constructor() : this(
        QuantumField()
    )

    companion object {
        fun run(atom: Atom) : Field {
            val proton = atom.getProton(ValueProton::class)
            return run(proton)
        }
        fun run(atom: Atom, kClass:KClass<*>) : Field {
            val proton = atom.getProton(kClass)
            return run(proton)
        }
        fun run(proton:Proton) : Field {
            var quark  : Quark = proton.getValueQuark()
            return quark.getAngularMomentum().run(Wavelength.field(proton))
        }
    }
    override fun absorb(photon: Photon) : Photon {
        var remainder = photon.propagate()
        remainder = field.absorb(remainder)
        return remainder
    }
    override fun emit() : Photon {
        return Photon(radiate())
    }

    private fun radiate() : String {
        return getLocalClassId()+
                field.emit().radiate()
    }

    private fun getLocalClassId() : String {
        return Absorber.getClassId(AngularMomentum::class)
    }

    public open fun getClassId() : String {
        return getLocalClassId()
    }
    fun getField() : Field {
        return field.getField()
    }

    fun momentum() : Any? {
        return field.getContent()
    }

    fun setAngularMomentum(content:Any?) : Any? {
        return setContent(content)
    }

    open fun run(arg: Field) : Field {
        return arg
    }

    fun i() : AngularMomentum {
        return this
    }
}