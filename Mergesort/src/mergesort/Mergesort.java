package mergesort;

public class Mergesort
{
	private static int[] values = {1, 5, 8, 9, 7, 4, 6, 2, 3};	//Array zur Speicherung der Liste		
	
	public static void main(String[] args) 						//Main-Methode
	{
		Mergesort ms = new Mergesort();							//neues Objekt ms der Klasse Mergesort
		ms.mergesort(0, values.length -1);						//Aufrufen der Sortiermethode mergesort für das ms Objekt
		
        for (int i = 0; i < values.length; i++) 			//Ausgabe der sortieren Liste
        {
            System.out.println(values[i]);
        }
	}
	
	//aufteilen der Liste in zwei Listen, rekursive Sortierung beider Listen, zusammenführen bedier Listen
	private void mergesort(int low, int high) 
	{
		if(low < high)											//wenn Array mehr als einen Eintrag hat
		{
			int middle = low + (high - low) / 2;				//Bestimmung der Arraymitte
			mergesort(low, middle);								//rekursive Sortierung der ersten Array Hälfte
			mergesort(middle+1, high);							//rekursive Sortierung der zweiten Array Hälfte
			merge(low, middle, high);							//zusammenführen beider Array Hälften zu einer sortierten Liste
		}			
	}

	//zusammenführen beider Listen, sodass diese geordnet sind
	private static void merge(int low, int middle, int high) 
	{
		int[] help = new int[values.length];					//Hilfsarray (Kopie der Liste, gleiche Länge wie values)
		int i, j;												//Zählvariabeln
		
		for(i = low; i <= middle; i++)							//Erzeugung einer Kopie der ersten Hälfte des values Arrays
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
			if(help[i] <= help[j])								//Vergleich zwischen Element erste Hälfte und Element zweite Hälfte
			{
				values[k] = help[i];							//wenn help i kleiner gleich als help j, wird help i in values an Stelle k einsortiert
				i++;
			}
			else
			{
				values[k] = help[j];							//wenn help i größer als help j, wird help j in values an Stelle k einsortiert
				j--;
			}
		}
	}
}