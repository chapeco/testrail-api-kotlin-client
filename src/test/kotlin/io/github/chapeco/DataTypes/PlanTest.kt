package io.github.chapeco.DataTypes

import io.github.chapeco.Utilities.Timestamp
import kotlinx.serialization.json.JSON
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class PlanTest
{
    @Test
    fun instantiatePlanTest()
    {
        val expectedPlan = Plan(
                assignedToId = 1,
                blockedCount = 1,
                completedOn = Timestamp(
                        time = 1000
                ),
                createdBy = 1,
                createdOn = Timestamp(
                        time = 1000
                ),
                

        )
        val actualPlan = Plan(

        )
        Assertions.assertEquals(expectedPlan,actualPlan)
    }

    @Test
    fun serializePlanTest()
    {
        val expectedPlan: String = ""
        val actualPlan = Plan(

        )
        println(JSON.unquoted.stringify(actualPlan))
        Assertions.assertEquals(expectedPlan,JSON.unquoted.stringify(actualPlan))
    }

    @Test
    fun deserializePlanTest()
    {
        val expectedPlan = Plan(

        )
        Assertions.assertEquals(expectedPlan,JSON.unquoted.parse<Plan>(""))
    }

    @Test
    fun getPlanTest()
    {

    }

    @Test
    fun getPlansTest()
    {

    }

    @Test
    fun addPlanTest()
    {

    }

    @Test
    fun updatePlanTest()
    {

    }

    @Test
    fun closePlanTest()
    {

    }

    @Test
    fun deletePlanTest()
    {

    }
}