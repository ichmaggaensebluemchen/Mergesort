package mergesort;

public class Mergesort
{
	private static int[] values = {1, 5, 8, 9, 7, 4, 6, 2, 3};	//Array zur Speicherung der Liste		
	
	public static void main(String[] args) 						//Main-Methode
	{
		Mergesort ms = new Mergesort();							//neues Objekt ms der Klasse Mergesort
		ms.mergesort(0, values.length -1);						//Aufrufen der Sortiermethode mergesort f�r das ms Objekt
		
        for (int i = 0; i < values.length; i++) 			//Ausgabe der sortieren Liste
        {
            System.out.println(values[i]);
        }
	}
	
	//aufteilen der Liste in zwei Listen, rekursive Sortierung beider Listen, zusammenf�hren bedier Listen
	private void mergesort(int low, int high) 
	{
		if(low < high)											//wenn Array mehr als einen Eintrag hat
		{
			int middle = low + (high - low) / 2;				//Bestimmung der Arraymitte
			mergesort(low, middle);								//rekursive Sortierung der ersten Array H�lfte
			mergesort(middle+1, high);							//rekursive Sortierung der zweiten Array H�lfte
			merge(low, middle, high);							//zusammenf�hren beider Array H�lften zu einer sortierten Liste
		}			
	}

	//zusammenf�hren beider Listen, sodass diese geordnet sind
	private static void merge(int low, int middle, int high) 
	{
		int[] help = new int[values.length];					//Hilfsarray (Kopie der Liste, gleiche L�nge wie values)
		int i, j;												//Z�hlvariabeln
		
		for(i = low; i <= middle; i++)							//Erzeugung einer Kopie der ersten H�lfte des values Arrays
		{
			help[i] = values[i];
		}
		
		for(j = middle+1; j <= high; j++)
		{
			help[high + middle+1 - j] = values[j];
		}
		
		i = low;
		j = high;
		
		for(int k = low; k <= high; k++)						//Einsortierung des kleineren Elements an Stelle k im values Array
		{
			if(help[i] <= help[j])								//Vergleich zwischen Element erste H�lfte und Element zweite H�lfte
			{
				values[k] = help[i];							//wenn help i kleiner gleich als help j, wird help i in values an Stelle k einsortiert
				i++;
			}
			else
			{
				values[k] = help[j];							//wenn help i gr��er als help j, wird help j in values an Stelle k einsortiert
				j--;
			}
		}
	}
}