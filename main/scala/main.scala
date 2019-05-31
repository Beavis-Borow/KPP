
import scala.annotation.tailrec
import scala.io.StdIn

object main {
  def main(args:Array[String]):Unit= {
    var continue: Boolean = true
    var max: Int = 0
    var ch: Int = 0



    while(continue)
    {
      println("Input array size: ")

      val n = StdIn.readInt()
      val intArray = new Array[Int](n)

      for (i <- 0 to n - 1) {
        print("Input:")
        val m = StdIn.readInt()
        intArray(i) = m
      }

      println("1. Без хвостовой рекурсии \n" +
        "2. С хвостовой рекурсией \n")
      val fl = StdIn.readInt()
      if (fl == 1)
      {
        for (i <- 0 to n - 1)
        {
          for(j<-0 to n-1)
          {
            if(intArray(i)==intArray(j))
            {
              ch+=1
            }
            else
            {
              if (max < ch)
              {
                max = ch
              }
              ch=0
            }
          }
          if (max < ch)
          {
            max = ch
          }
          ch=0
        }
        println("\nDlina = "+max)
        max=0
      }
      else
      if (fl == 2)
      {
        max= find_kol(intArray, 0, 1,1)

        println("Dlina = "+max)
        max = 0
      }
      else
      {
        println("ERROR")
        continue=false
      }
    }

    @tailrec
    def find_kol(arr: Array[Int],j: Int,max: Int,kol: Int): Int = {

      if(j==arr.length-1)max
      else
      {
        println("in func, max = "+max,j,kol)
        if(arr(j)==arr(j+1))
        {
          println(" x==x+1 , max = "+max,j,kol)
          if(max<=kol)
            find_kol(arr,j+1,kol+1,kol+1)
          else
            find_kol(arr,j+1,max,kol+1)
        }
        else
        {
          println("else , max = "+max,j,kol)
          if(max<=kol)
            find_kol(arr,j+1,kol,1)
          else
            find_kol(arr,j+1,max,1)
        }
      }
    }
  }
}