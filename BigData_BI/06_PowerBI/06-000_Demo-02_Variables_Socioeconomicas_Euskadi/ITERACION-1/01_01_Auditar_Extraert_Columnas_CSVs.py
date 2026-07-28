import os
import csv
def encoding_delimitador_audita(ruta):
    encodings = ['utf-8', 'latin-1', 'cp1252']   
    for encoding in encodings:
        try:
            with open(ruta, mode='r', encoding=encoding) as archivo:
                ventana_test = archivo.read(2048)
                archivo.seek(0)
                delimiter = ';' if ventana_test.count(';') > ventana_test.count(',') else ','
                audita = csv.reader(archivo, delimiter=delimiter)
                columnas = next(audita)
                columnas = [columna.strip().strip('"').strip("'") for columna in columnas if columna.strip()]
                return columnas, encoding, delimiter
        except Exception:
            continue
    return None, None, None

def auditar_directorio(directorio="./origen"):
    if not os.path.exists(directorio):
        print(f"[!] El directorio '{directorio}' no existe.")
        return
    csv_todos = [archivo for archivo in os.listdir(directorio) if archivo.endswith('.csv')]
    if not csv_todos:
        print(f"[!] No se han encontrado archivos .csv en el directorio '{directorio}'.")
        return
    print(f"Analizando {len(csv_todos)} archivos CSV ...\n")
    cada_columna = set()
    resumen = {}
    for csv in sorted(csv_todos):
        ruta = os.path.join(directorio, csv)
        columnas, _, _ = encoding_delimitador_audita(ruta)
        if columnas:
            resumen[csv] = columnas
            cada_columna.update(columnas)
        else:
            print(f"[!] Error al leer la cabecera de: {csv}")
    print(" # MAPA GLOBAL:\n")
    print(f"> Se han encontrado {len(cada_columna)} columnas ÚNICAS en total.")
    print("\n---\n")
    for col in sorted(cada_columna):
        print(f"  - {col}")
    
    print("\n---\n")
    print("#### DESGLOSE POR ARCHIVO")
    for csv, columnas in resumen.items():
        print(f"\n - {csv} ( {len(columnas)} columnas):" )
        for columna in columnas:
            print(f"    * {columna}")

if __name__ == "__main__":
    auditar_directorio()