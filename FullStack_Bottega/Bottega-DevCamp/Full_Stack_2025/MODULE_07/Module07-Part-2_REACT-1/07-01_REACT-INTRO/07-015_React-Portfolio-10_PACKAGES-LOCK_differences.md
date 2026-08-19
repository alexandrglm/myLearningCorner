# 07-015: Differences Between package.json and package-lock.json

**package.json**: Flexible dependencies with `~4.16.3` (accepts minor patches)

**package-lock.json**: Exact versions and complete metadata

- Specific versions without `~`  
- Download URLs (resolve)  
- Security checksums (integrity)  
- Nested dependencies (each library has its own dependencies)  

**⚠️ Critical rule**: NEVER modify package-lock.json - it is generated automatically.

**Function**: Ensures identical installations on any machine (exact reproducibility).

**Usage**: Use package.json for manual management, package-lock.json for reference only.
