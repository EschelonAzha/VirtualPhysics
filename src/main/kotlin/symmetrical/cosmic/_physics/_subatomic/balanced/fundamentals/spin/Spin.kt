package symmetrical.cosmic._physics._subatomic.balanced.fundamentals.spin

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.balanced.values.Field
import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics._subatomic.luminescent.IQuantumField
import symmetrical.cosmic._physics._subatomic.luminescent.QuantumField
import symmetrical.cosmic._physics._subatomic.matter.hadrons.baryons.Proton
import symmetrical.cosmic._physics._subatomic.matter.quarks.Quark
import symmetrical.cosmic._physics.atomic.atoms.Atom
import symmetrical.cosmic.dictionary.protons.ValueProton
import kotlin.reflect.KClass

class Spin(
    private val field: QuantumField = QuantumField(Static.PLUS)
) :
    IQuantumField by field {

    constructor() : this(
        QuantumField(Static.PLUS)
    )

    object Static {
        const val PLUS :Int      = +1
        const val MINUS:Int      = -1
    }

    companion object {
        fun isMinus(atom: Atom) : Any? {
            return isMinus(atom.getProton(ValueProton::class))
        }
        fun isMinus(atom: Atom, kClass: KClass<*>) : Any? {
            return isMinus(atom.getProton(kClass))
        }
        fun isMinus(proton: Proton) : Any? {
            var quark  : Quark = proton.getValueQuark()
            return quark.getSpin().spin()
        }
        fun isPlus(atom: Atom) : Any? {
            return isPlus(atom.getProton(ValueProton::class))
        }
        fun isPlus(atom: Atom, kClass: KClass<*>) : Any? {
            return isPlus(atom.getProton(kClass))
        }
        fun isPlus(proton: Proton) : Any? {
            var quark  : Quark = proton.getValueQuark()
            return quark.getSpin().spin()
        }


    }

    fun i() : Spin {
        return this
    }

    override fun absorb(photon: Photon) : Photon {
        var remainder = photon.propagate()
        remainder = field.absorb(remainder)
        return remainder
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

    private fun radiate() : String {
        return getLocalClassId()+
                field.emit().radiate()
    }

    private fun getLocalClassId() : String {
        return Absorber.getClassId(Spin::class)
    }
    fun isPlus() : Boolean {
        return field.toInt() > 0
    }
    fun isMinus() : Boolean {
        return field.toInt() < 0
    }

    fun setSpin(content:Any?) : Any? {
        return setContent(content)
    }

    fun spin() : Any? {
        return field.getContent()
    }

    fun spinPlus() : Spin {
        field.setContent(Spin.Static.PLUS)
        return this
    }
    fun spinMinus() : Spin {
        field.setContent(Spin.Static.MINUS)
        return this
    }


}