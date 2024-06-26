package symmetrical.dictionary.protons
/*
 * This file is part of Virtual Physics.
 *
 * Copyright (C) [2024] Stephen R. DeSofi AKA Eschelon Azha
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
import symmetrical.physics.subatomic.balanced.Particle
import symmetrical.physics.subatomic.balanced.values.Field
import symmetrical.physics.subatomic.bosons.Photon
import symmetrical.physics.subatomic.luminescent.IMatter
import symmetrical.physics.subatomic.luminescent.Matter
import symmetrical.physics.subatomic.matter.hadrons.baryons.Proton
import kotlin.reflect.KClass

class CRUDProton (
    private val matterAntiMatter: IMatter = Matter().with(CRUDProton::class),
) : Proton(),
    IMatter by matterAntiMatter
{

    object Static {
        const val CREATE    = 1
        const val READ      = 0
        const val UPDATE    = 2
        const val DELETE    = -1
    }

    fun isCreate() : Boolean {
        return getField().toInt() == Static.CREATE
    }
    fun isDelete() : Boolean {
        return getField().toInt() == Static.DELETE
    }
    fun isRead() : Boolean {
        return getField().toInt() == Static.READ
    }
    fun isUpdate() : Boolean {
        return getField().toInt() == Static.UPDATE
    }

    fun setCreate() : CRUDProton {
        setContent(CRUDProton.Static.CREATE)
        return this
    }
    fun setDelete() : CRUDProton {
        setContent(CRUDProton.Static.DELETE)
        return this
    }
    fun setRead() : CRUDProton {
        setContent(CRUDProton.Static.READ)
        return this
    }
    fun setUpdate() : CRUDProton {
        setContent(CRUDProton.Static.UPDATE)
        return this
    }


    // ########################### EMISSIONS ###########################
    override fun absorb(photon: Photon) : Photon {
        matterAntiMatter.check(photon);

        var remainder = photon.propagate()
        remainder = super.absorb(remainder)
        return remainder
    }
    override fun emit() : Photon {
        val classId = matterAntiMatter.getClassId()
        return Photon().with(radiate())
    }
    override fun getClassId() : String {
        return matterAntiMatter.getClassId()
    }
    private fun radiate() : String {
        if (Particle.Static.debuggingOn) {
            println("CrudProton")
        }
        val classId : String = matterAntiMatter.getClassId()
        val proton  : String = super.emit().radiate()
        return classId+proton
    }
    // ########################### EMISSIONS ###########################

}