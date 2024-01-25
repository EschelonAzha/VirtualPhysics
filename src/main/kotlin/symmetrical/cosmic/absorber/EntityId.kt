package symmetrical.cosmic.absorber
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

import asymmetrical.physics.machine.vm.Classes
import kotlin.reflect.KClass

class EntityId() {
    lateinit var classId:String
    lateinit var classType:KClass<*>
    fun with(classId:String, classType: KClass<*>) : EntityId {
        this.classId    = classId
        this.classType  = classType
        return this
    }
    fun has(classType:KClass<*>) : Boolean {
        return this.classType == classType
    }
    fun newInstance() : Any? {
        return Classes.createInstance(classType)
    }
    override fun toString() : String {
        return "["+classId+":"+classType.simpleName+"]"
    }
}