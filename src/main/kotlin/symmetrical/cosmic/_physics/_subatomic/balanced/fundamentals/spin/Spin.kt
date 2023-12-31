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
        QuantumField(Static.ZERO)
    )
    constructor(content:Int) : this() {
        field.setContent(content)
    }

    object Static {
        const val PLUS :Int      = +1
        const val ZERO :Int      = 0
        const val MINUS:Int      = -1
    }

    companion object {
        fun isMinus(atom: Atom) : Boolean {
            return isMinus(atom.getProton(ValueProton::class))
        }
        fun isMinus(atom: Atom, kClass: KClass<*>) : Boolean {
            return isMinus(atom.getProton(kClass))
        }
        fun isMinus(proton: Proton) : Boolean {
            var quark  : Quark = proton.getValueQuark()
            return isMinus(quark)
        }
        fun isMinus(quark: Quark) : Boolean {
            return quark.getSpin().spin().toBoolean()
        }
        fun isPlus(atom: Atom) : Boolean {
            return isPlus(atom.getProton(ValueProton::class))
        }
        fun isPlus(atom: Atom, kClass: KClass<*>) : Boolean {
            return isPlus(atom.getProton(kClass))
        }
        fun isPlus(proton: Proton) : Boolean {
            var quark  : Quark = proton.getValueQuark()
            return isPlus(quark)
        }
        fun isPlus(quark: Quark) : Boolean {
            return quark.getSpin().spin().toBoolean()
        }
        //
        fun isZero(atom: Atom) : Boolean {
            return isZero(atom.getProton(ValueProton::class))
        }
        fun isZero(atom: Atom, kClass: KClass<*>) : Boolean {
            return isZero(atom.getProton(kClass))
        }
        fun isZero(proton: Proton) : Boolean {
            var quark  : Quark = proton.getValueQuark()
            return isZero(quark)
        }
        fun isZero(quark: Quark) : Boolean {
            return quark.getSpin().spin().toBoolean()
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
        return field.toInt() == 1
    }
    fun isMinus() : Boolean {
        return field.toInt() == -1
    }
    fun isZero() : Boolean {
        return field.toInt() == 0
    }

    fun setSpin(content:Any?) : Any? {
        return setContent(content)
    }

    fun spin() : Field {
        return field.getField()
    }

    fun spinPlus() : Spin {
        field.setContent(Spin.Static.PLUS)
        return this
    }
    fun spinMinus() : Spin {
        field.setContent(Spin.Static.MINUS)
        return this
    }
    fun spinZero() : Spin {
        field.setContent(Spin.Static.ZERO)
        return this
    }


}