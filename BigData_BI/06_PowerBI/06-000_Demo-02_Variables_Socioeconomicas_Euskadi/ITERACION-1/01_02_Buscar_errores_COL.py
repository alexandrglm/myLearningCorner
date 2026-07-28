import glob
import pandas as pd

DIRECTORIO_ORIGEN = "./origen"
PATRON_BUSQUEDA = "col"
ENCODINGS = ['utf-8-sig', 'latin-1', 'cp1252']

PATRON_COL = lambda columnas: [columna for columna in columnas if PATRON_BUSQUEDA in columna.lower()]
def identificar_archivos_con_col_generica(directorio=DIRECTORIO_ORIGEN):
    archivos_csv = glob.glob(f"{directorio}/*.csv")
    archivos_con_genericas = []
    print(f"[*] Analizando {len(archivos_csv)} archivos CSV en busca de columnas con PATRON elegido...")
    for ruta_archivo in archivos_csv:
        df = None
        for encoding in ENCODINGS:
            try:
                df = pd.read_csv(ruta_archivo, nrows=1, encoding=encoding)
                break
            except Exception:
                continue

        if df is None:
            continue
        columnas = [str(columna) for columna in df.columns]
        columnas_genericas = PATRON_COL(columnas)
        if columnas_genericas:
            archivos_con_genericas.append((ruta_archivo, columnas))
    print(f"- ARCHIVOS QUE CONTIENEN COLUMNAS 'COLx' (Total: {len(archivos_con_genericas)}):")
    for ruta_archivo, columnas in archivos_con_genericas:
        print(f" - {ruta_archivo} \n   └─ Cabeceras actuales: {columnas}\n")
    print("\n---")

if __name__ == "__main__":
    identificar_archivos_con_col_generica()